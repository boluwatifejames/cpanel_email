package com.example.cpanel_email.controller;

import com.example.cpanel_email.request.Contact;
import com.example.cpanel_email.request.Volunteer;
import com.example.cpanel_email.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ResponseService responseService;
    @PostMapping("/contact")
        public void contact (@RequestBody Contact contact){
        responseService.contactUs(contact);
    }


    @PostMapping("volunteer")
    public void volunteer(@RequestBody Volunteer volunteer){
        responseService.volunteerWithUs(volunteer);
    }
}
