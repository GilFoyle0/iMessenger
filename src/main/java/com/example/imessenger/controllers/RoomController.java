package com.example.imessenger.controllers;


import com.example.imessenger.entity.Message;
import com.example.imessenger.entity.Room;
import com.example.imessenger.service.MessageService;
import com.example.imessenger.service.ParticipantService;
import com.example.imessenger.service.RoomService;

import com.example.imessenger.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    final
    RoomService roomService;
    final
    MessageService messageService;
    final ParticipantService participantService;

    final
    UserService userService;

    public RoomController(
            RoomService roomService,
            MessageService messageService,
            ParticipantService participantService,
            UserService userService) {
        this.roomService = roomService;
        this.messageService = messageService;
        this.participantService = participantService;
        this.userService = userService;
    }

    @RequestMapping(value = {"/rooms", "/"})
    public String getRooms(Model model)
    {
        if (userService.checkAdmin()) {
            model.addAttribute("admin", "admin");
        }
        List<Room> rooms = roomService.getRooms();
        if (rooms.size() == 0) {
            return "rooms";
        }
        return "redirect:/rooms/" + rooms.get(0).getId();
    }
    @GetMapping("/rooms/{roomId}")
    public String getRoom( @PathVariable long roomId, Model model) {
        List<Room> rooms = roomService.getRooms();
       Room currentRoom = roomService.getRoom(roomId);
       List<Message> messages = messageService.getAllMessage(roomId);
       if (userService.checkAdmin()) {
           model.addAttribute("admin", "admin");
       }
       model.addAttribute("currentRoom", currentRoom);
       model.addAttribute("messages", messages);
       model.addAttribute("rooms", rooms);
       model.addAttribute("participants", participantService.getRoomParticipant(roomId));
        return "rooms";
    }
    @PostMapping("/rooms")
    public String createRoom(
            @RequestParam String nameRoom
    )
    {
     Room room = roomService.createRoom(nameRoom);
        return "redirect:/rooms/"+room.getId();
    }
    @GetMapping("/rooms/{roomId}/remove")
        public String removeRoom(@PathVariable long roomId) {
        participantService.removeParticipant(roomId);
        return "redirect:/rooms";
        }
    @GetMapping("/rooms/{roomId}/find")
    public String findRoom(@PathVariable long roomId, Model model) {
        Room room = roomService.getRoom(roomId);
        if (room == null) {
            model.addAttribute("error", "error");
            return getRoom(roomId, model);
        }
        return "redirect:/rooms/"+room.getId();
    }
}
