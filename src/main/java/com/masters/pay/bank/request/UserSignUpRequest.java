package com.masters.pay.bank.request;

import lombok.Data;

@Data
public class UserSignUpRequest {
    private String firstName;
    private String lastName;
    private String emailId;
    private String username;
    private String password;
    private String phoneNo;
}
