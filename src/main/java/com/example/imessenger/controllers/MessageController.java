package com.example.imessenger.controllers;

import com.example.imessenger.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    final
    MessageService messageService;

    public MessageController(
            MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/rooms/{roomId}")
    public String creteMessage(@PathVariable long roomId, @RequestParam String message){
        messageService.createMessage(roomId, message);
        return "redirect:/rooms/"+roomId;
    }
}
