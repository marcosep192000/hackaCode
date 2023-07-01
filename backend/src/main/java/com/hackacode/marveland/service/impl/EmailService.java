package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.service.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String body) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("carolinabejar6@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);
    }
}
