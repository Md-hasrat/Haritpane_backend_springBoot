package com.Haritpane.springBoot_haritpane_backend.services;

import com.Haritpane.springBoot_haritpane_backend.exception.EmailSendingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendEmailService {

    private final JavaMailSender mailSender;

    public void sendHtmlEmail(String to, String subject, String html) {

        try {

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);

            mailSender.send(message);

            log.info("Email sent successfully to {}", to);

        } catch (Exception e) {

            log.error("Failed to send email", e);
            throw new EmailSendingException("Unable to send email. Please try again later.", e);
        }
    }
}