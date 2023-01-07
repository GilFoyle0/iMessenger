package com.example.imessenger.repository;

import com.example.imessenger.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByRoomId(long id);
}
