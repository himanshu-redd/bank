package com.masters.pay.bank.request;

import lombok.Data;

@Data
public class UserLogInRequest {
    private String emailId;
    private String password;
}
