package com.keshav.projectify.repository;

import com.keshav.projectify.modal.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatIdOrderByCreatedAtAsc(Long chatId);
}
