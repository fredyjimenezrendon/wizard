package io.indorse.test.authentication.services.impl;

import io.indorse.test.authentication.dao.dto.User;
import io.indorse.test.authentication.services.EmailService;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailServiceImpl implements EmailService {

    public void sendSimpleEmail(User user) {
        final String username = "indorsetest@gmail.com";
        final String password = "Indorsetest123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("indorsetestl@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            message.setSubject("Confirm your email");
            message.setContent("<a href='http://localhost:8080/wizard/confirm/"  + user.getToken() + "'>Click here to confirm your email</a>", "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}