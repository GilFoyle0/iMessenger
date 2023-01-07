package com.example.imessenger.repository;

import com.example.imessenger.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findById(long id);

    List<Room> findAll();
}
