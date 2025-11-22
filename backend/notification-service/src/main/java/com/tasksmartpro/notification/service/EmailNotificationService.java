package com.tasksmartpro.notification.service;

import com.tasksmartpro.notification.dto.EmailNotificationRequest;
import com.tasksmartpro.notification.entity.*;
import com.tasksmartpro.notification.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailNotificationService {

    private final JavaMailSender mailSender;
    private final NotificationRepository notificationRepository;
    private final NotificationLogRepository logRepository;

    public void sendEmail(EmailNotificationRequest request) {

        NotificationEntity notif = notificationRepository.save(
                NotificationEntity.builder()
                        .tenantId(request.getTenantId())
                        .recipient(request.getTo())
                        .subject(request.getSubject())
                        .message(request.getMessage())
                        .type("EMAIL")
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(request.getTo());
            msg.setSubject(request.getSubject());
            msg.setText(request.getMessage());

            mailSender.send(msg);

            logRepository.save(
                    NotificationLogEntity.builder()
                            .notificationId(notif.getId())
                            .status("SUCCESS")
                            .details("Email sent successfully")
                            .timestamp(LocalDateTime.now())
                            .build()
            );
        }
        catch (Exception e) {
            logRepository.save(
                    NotificationLogEntity.builder()
                            .notificationId(notif.getId())
                            .status("FAILED")
                            .details(e.getMessage())
                            .timestamp(LocalDateTime.now())
                            .build()
            );
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}
