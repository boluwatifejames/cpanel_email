package com.example.cpanel_email.request;

//import com.example.cpanel_email.data.AreaOfInterest;
import lombok.Data;



@Data
public class Volunteer {
    private String firstName;
    private String lastName;
    private String email;
    private String areaOfInterest;
    private String preferredMethodOfContact;
    private String message;
}
