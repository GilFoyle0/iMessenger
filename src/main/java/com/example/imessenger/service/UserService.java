package com.example.imessenger.service;

import com.example.imessenger.entity.Role;
import com.example.imessenger.entity.User;
import com.example.imessenger.repository.ParticipantRepository;
import com.example.imessenger.repository.RoomRepository;
import com.example.imessenger.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final
    UserRepository userRepository;
    final
    RoomRepository roomRepository;
    final
    ParticipantRepository participantRepository;

    public UserService(UserRepository userRepository,
                       RoomRepository roomRepository,
                       ParticipantRepository participantRepository
    )
    {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.participantRepository = participantRepository;
    }

    public boolean checkAdmin() {
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        for (Role role : userFromDB.getRoles()) {
            if (role.equals(Role.ADMIN)) {
                return true;
            }
        }
        return false;
    }


}
