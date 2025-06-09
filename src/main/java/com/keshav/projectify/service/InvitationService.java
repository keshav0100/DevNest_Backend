package com.keshav.projectify.service;

import com.keshav.projectify.modal.Invitation;
import jakarta.mail.MessagingException;

public interface InvitationService {

    public void sendInvitation(String email,Long projectId) throws MessagingException;

    public Invitation acceptInvitation(String token,Long userId) throws Exception;

    public String getTokenByUserMail(String email);

    void deleteToken(String token);

}
