package com.keshav.projectify.service;

import com.keshav.projectify.modal.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Long senderId,Long chatId, String content)throws Exception;

    List<Message> getMesssagesByProjectId(Long projectId)throws Exception;
}
