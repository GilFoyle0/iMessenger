package com.example.imessenger.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "room")
@Setter
@Getter
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public Room (String name) {
        this.name = name;
    }
}