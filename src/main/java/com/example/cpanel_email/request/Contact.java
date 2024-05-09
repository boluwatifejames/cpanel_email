package com.example.cpanel_email.request;

import lombok.Data;

@Data
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}
