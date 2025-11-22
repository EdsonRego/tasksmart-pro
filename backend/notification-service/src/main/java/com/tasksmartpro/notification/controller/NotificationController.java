package com.tasksmartpro.notification.controller;

import com.tasksmartpro.notification.dto.*;
import com.tasksmartpro.notification.service.NotificationDispatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationDispatcherService dispatcher;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailNotificationRequest request) {
        dispatcher.sendEmail(request);
        return ResponseEntity.ok("Email sent.");
    }

    @PostMapping("/event")
    public ResponseEntity<String> sendEvent(@RequestBody EventNotificationRequest request) {
        dispatcher.dispatchEvent(request);
        return ResponseEntity.ok("Event dispatched.");
    }
}
