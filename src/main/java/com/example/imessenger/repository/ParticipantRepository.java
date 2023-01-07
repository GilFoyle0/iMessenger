package com.example.imessenger.repository;

import com.example.imessenger.entity.Participant;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    Participant findByUserIdAndRoomId(long userId, long roomId);
    List<Participant> findByUserId(long userId);
    List<Participant> findByRoomId(long roomId);

}
