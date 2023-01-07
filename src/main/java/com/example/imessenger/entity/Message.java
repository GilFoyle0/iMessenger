package com.example.imessenger.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "message")
@Getter
@Setter
@RequiredArgsConstructor
public class Message {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy ="increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @Column(name = "message", length = 8192)
    private String message;
    private Date created;
    public Message(String message, User user, Room room) {
        this.message = message;
        this.user = user;
        this.room = room;
    }
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat( "hh:mm");
        return dateFormat.format(this.created);
    }
}
