package com.keshav.projectify.service;

import com.keshav.projectify.modal.Chat;
import com.keshav.projectify.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat){
        return chatRepository.save(chat);
    }
}
