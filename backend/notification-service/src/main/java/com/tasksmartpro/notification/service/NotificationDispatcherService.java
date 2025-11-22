package com.tasksmartpro.notification.service;

import com.tasksmartpro.notification.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationDispatcherService {

    private final EmailNotificationService emailService;
    private final EventNotificationService eventService;

    public void sendEmail(EmailNotificationRequest request) {
        emailService.sendEmail(request);
    }

    public void dispatchEvent(EventNotificationRequest request) {
        eventService.sendEvent(request);
    }
}
