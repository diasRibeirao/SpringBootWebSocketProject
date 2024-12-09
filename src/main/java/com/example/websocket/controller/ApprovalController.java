package com.example.websocket.controller;

import com.example.websocket.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/approve/{id}")
    public void approve(@PathVariable Long id) {
        notificationService.notifyApprovalRemoved(id);
    }
}