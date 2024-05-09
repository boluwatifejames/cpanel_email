package com.example.cpanel_email.service;

import com.example.cpanel_email.request.Contact;
import com.example.cpanel_email.request.Volunteer;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Slf4j
@RequiredArgsConstructor
@Service
public class EmailService {

        @Value("${mail.host}")
        private String host;

        @Value("${mail.port}")
        private String port;

        @Value("${mail.username}")
        private String username;

        @Value("${mail.password}")
        private String password;


        public void sendMessage(Contact contact) {
            String companyMail = "bosingwa100@gmail.com";
            sendEmail(companyMail, "Contact Us Inquiry", constructContactMessage(contact));
        }

        public void sendMessage(Volunteer volunteer) {
            String companyMail = "rescepientmail@mail.com";
            sendEmail(companyMail, "Volunteer Inquiry", constructVolunteerMessage(volunteer));
        }

        private void sendEmail(String recipientEmail, String subject, String body) {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
                message.setSubject(subject);
                message.setText(body);

                Transport.send(message);

                log.info("Email sent successfully to {}", recipientEmail);
            } catch (MessagingException e) {
                log.error("Error sending email: {}", e.getMessage());
                throw new RuntimeException("Error sending email", e);
            }
        }

        private String constructContactMessage(Contact contact) {
            return "Name: " + contact.getFirstName() + " " + contact.getLastName() + "\n" +
                    "Email: " + contact.getEmail() + "\n" +
                    "Message: " + contact.getMessage();
        }

        private String constructVolunteerMessage(Volunteer volunteer) {
            return "Name: " + volunteer.getFirstName() + " " + volunteer.getLastName() + "\n" +
                    "Email: " + volunteer.getEmail() + "\n" +
                    "Area of Specialization: " + volunteer.getAreaOfInterest() + "\n" +
                    "Preferred Method of Contact: " + volunteer.getPreferredMethodOfContact() + "\n" +
                    "Message: " + volunteer.getMessage();
        }
    }

