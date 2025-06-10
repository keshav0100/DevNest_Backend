package com.keshav.projectify.controller;

import com.keshav.projectify.modal.Chat;
import com.keshav.projectify.modal.Message;
import com.keshav.projectify.modal.User;
import com.keshav.projectify.request.CreateMessageRequest;
import com.keshav.projectify.service.MessageService;
import com.keshav.projectify.service.ProjectService;
import com.keshav.projectify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;


    @PostMapping("/send")
    public ResponseEntity sendMessage(@RequestBody CreateMessageRequest request) throws Exception {
        User user=userService.findUserById(request.getSenderId());

        Chat chats=projectService.getProjectById(request.getProjectId()).getChat();

        if(chats==null) throw new Exception("Chats not found ");

        Message sentMessage=messageService.sendMessage(request.getSenderId(),
                request.getProjectId(),request.getContent());
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity chat(@PathVariable Long projectId) throws Exception {
        List<Message> messages=messageService.getMesssagesByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}
