package com.example.imessenger.controllers;

import com.example.imessenger.entity.Role;
import com.example.imessenger.entity.Room;
import com.example.imessenger.entity.User;
import com.example.imessenger.service.MessageService;
import com.example.imessenger.service.ParticipantService;
import com.example.imessenger.service.RoomService;
import com.example.imessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
    final
    RoomService roomService;
    final
    UserService userService;
    public AdminController(
            RoomService roomService,
            UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    String getAdminPanel(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        if (userService.checkAdmin()) {
            model.addAttribute("admin", "admin");
            if (rooms.size() != 0) {
                model.addAttribute("rooms", rooms);
            }
            return "admin_panel";
        }
        return "redirect:/rooms";
    }

    @GetMapping("/admin/{roomId}")
    String removeRoom(@PathVariable long roomId) {
        if (userService.checkAdmin()) {
            roomService.deleteRoom(roomId);
            return "redirect:/admin";
        }
        return "redirect:/rooms";
    }
}
