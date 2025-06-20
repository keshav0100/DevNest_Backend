package com.keshav.projectify.service;

import com.keshav.projectify.modal.Chat;
import com.keshav.projectify.modal.Message;
import com.keshav.projectify.modal.User;
import com.keshav.projectify.repository.MessageRepository;
import com.keshav.projectify.repository.ProjectRepository;
import com.keshav.projectify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectService projectService;


    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
        User sender=userRepository.findById(senderId)
                .orElseThrow(() -> new Exception("User not found with id "+senderId));
        Chat chat=projectService.getProjectById(projectId).getChat();

        Message message=new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage=messageRepository.save(message);

        chat.getMessages().add(savedMessage);
        return savedMessage;
    }

    @Override
    public List<Message> getMesssagesByProjectId(Long projectId) throws Exception {
        Chat chat=projectService.getChatByProjectId(projectId);
        List<Message>findByChatIdOrderByCreatedAtAsc=messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());

        return findByChatIdOrderByCreatedAtAsc;

    }
}
