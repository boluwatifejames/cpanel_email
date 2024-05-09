package com.example.cpanel_email.service;

import com.example.cpanel_email.entity.MessagesDb;
import com.example.cpanel_email.repository.ReceivedMessagesRepo;
import com.example.cpanel_email.request.Contact;
import com.example.cpanel_email.request.Volunteer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final EmailService emailService;
    private final ReceivedMessagesRepo messagesRepo;

    public void contactUs(Contact contact) {
        MessagesDb userInput = new MessagesDb();
        userInput.setFirstName(contact.getFirstName());
        userInput.setLastName(contact.getLastName());
        userInput.setUserMailOrContactInfo(contact.getEmail());
        userInput.setUserMessage(contact.getMessage());
        messagesRepo.save(userInput);
        emailService.sendMessage(contact);

    }

    public void volunteerWithUs(Volunteer volunteer) {
        MessagesDb userInput = new MessagesDb();
        userInput.setFirstName(volunteer.getFirstName());
        userInput.setLastName(volunteer.getLastName());
        userInput.setUserMailOrContactInfo(volunteer.getEmail());
        userInput.setUserMessage(volunteer.getMessage());
        userInput.setAreaOfInterest(volunteer.getAreaOfInterest());
        userInput.setPreferredMethodOfContact(volunteer.getPreferredMethodOfContact());
        messagesRepo.save(userInput);
         emailService.sendMessage(volunteer);
    }
}
