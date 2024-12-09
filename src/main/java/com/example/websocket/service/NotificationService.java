package com.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void notifyApprovalRemoved(Long approvalId) {
        messagingTemplate.convertAndSend("/topic/approvals", approvalId);
    }
}