package com.example.imessenger.service;

import com.example.imessenger.entity.Message;
import com.example.imessenger.entity.Room;
import com.example.imessenger.entity.User;
import com.example.imessenger.repository.MessageRepository;
import com.example.imessenger.repository.ParticipantRepository;
import com.example.imessenger.repository.RoomRepository;
import com.example.imessenger.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MessageService {

    final
    UserRepository userRepository;
    final
    RoomRepository roomRepository;
    final
    MessageRepository messageRepository;

    public MessageService(
            UserRepository userRepository,
            RoomRepository roomRepository,
            MessageRepository messageRepository
    )
    {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }
    public void createMessage(long roomId, @RequestParam String text) {
        User userFromDB = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Room currentRoom = roomRepository.findById(roomId);
        Message message = new Message(text, userFromDB, currentRoom);
        messageRepository.save(message);
    }

    public List<Message> getAllMessage(long roomId) {
        return messageRepository.findByRoomId(roomId);
    }
}
