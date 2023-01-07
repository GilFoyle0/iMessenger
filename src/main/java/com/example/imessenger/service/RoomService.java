package com.example.imessenger.service;


import com.example.imessenger.entity.Participant;
import com.example.imessenger.entity.Role;
import com.example.imessenger.entity.Room;
import com.example.imessenger.entity.User;
import com.example.imessenger.repository.ParticipantRepository;
import com.example.imessenger.repository.RoomRepository;
import com.example.imessenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import static com.example.imessenger.entity.Role.ADMIN;

@Service
public class RoomService {

    final
    UserRepository userRepository;
    final
    RoomRepository roomRepository;
    final
    ParticipantRepository participantRepository;
    final
    UserService userService;
    public RoomService(UserRepository userRepository,
                       RoomRepository roomRepository,
                       ParticipantRepository participantRepository,
                       UserService userService)
    {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.participantRepository = participantRepository;
        this.userService = userService;
    }
    public Room getRoom(long roomId) {
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Room currentRoom = roomRepository.findById(roomId);
        if (currentRoom == null) {
            return null;
        }
        if (participantRepository.findByUserIdAndRoomId(userFromDB.getId(), roomId) == null) {
            Participant participant = new Participant(userFromDB, currentRoom);
            participantRepository.save(participant);
        }
        return currentRoom;
    }


    public List<Room> getRooms() {
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List <Participant> participantRooms = participantRepository.findByUserId(userFromDB.getId());
        List <Room> rooms = new ArrayList<>();
        if (participantRooms != null) {
            for (Participant participantRoom:participantRooms) {
                Room room = participantRoom.getRoom();
                rooms.add(room);
            }
        }
        return rooms;
    }

    public List<Room> getAllRooms() {
        if(userService.checkAdmin()) {
           return roomRepository.findAll();
        }
        return null;
    }
    public void deleteRoom(long roomId) {
        Room room = roomRepository.findById(roomId);
        if (room != null) {
            roomRepository.delete(room);
        }
    }

    public Room createRoom(String nameRoom) {

        if (nameRoom.length() == 0) {
            return null;
        }
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Room room = new Room(nameRoom);
        Participant participant = new Participant(userFromDB, roomRepository.save(room));
        participantRepository.save(participant);
        return room;
    }


}
