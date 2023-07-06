package com.masters.pay.bank.response;

import com.masters.pay.bank.dao.User;
import lombok.Data;

@Data
public class UserSignUpResponse extends BaseResponse{
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
    private String vpa;
    private Long balanceAmount;
}
