package com.example.imessenger.service;

import com.example.imessenger.entity.Participant;
import com.example.imessenger.entity.Room;
import com.example.imessenger.entity.User;
import com.example.imessenger.repository.MessageRepository;
import com.example.imessenger.repository.ParticipantRepository;
import com.example.imessenger.repository.RoomRepository;
import com.example.imessenger.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParticipantService {
    final
    UserRepository userRepository;
    final
    RoomRepository roomRepository;
    final
    ParticipantRepository participantRepository;


    public ParticipantService(
            UserRepository userRepository,
            RoomRepository roomRepository,
            ParticipantRepository participantRepository
    )
    {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.participantRepository = participantRepository;
    }


    public List<Participant> getRoomParticipant(long roomId) {
        return participantRepository.findByRoomId(roomId);
    }

    public void removeParticipant(long roomId) {
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Participant participant = participantRepository.findByUserIdAndRoomId(userFromDB.getId(), roomId);
        if (participant != null) {
            participantRepository.delete(participant);
        }
    }

    //    public void createParticipant(long roomId, String username) {
//        Room currentRoom = roomRepository.findById(roomId);
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            return;
//        }
//        if (participantRepository.findByUserIdAndRoomId(user.getId(), roomId) == null) {
//            Participant newParticipant = new Participant(user, currentRoom);
//            participantRepository.save(newParticipant);
//        }
//    }

}
