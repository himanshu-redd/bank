package com.masters.pay.bank.util;


import com.masters.pay.bank.dao.User;
import com.masters.pay.bank.repository.UserRepo;
import com.masters.pay.bank.response.BaseResponse;
import com.masters.pay.bank.response.UserSignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUtil {
    @Autowired
    UserRepo userRepo;

    public static BaseResponse getFailedBaseResponse(String code, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("FALSE");
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse getSuccessBaseResponse(String code, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("TRUE");
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse getUserSignUpResponse(String code, String message, String firstName, String lastName, String phoneNo, String emailId, String vpa, Long balance) {
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
        userSignUpResponse.setStatus("TRUE");
        userSignUpResponse.setCode(code);
        userSignUpResponse.setMessage(message);
        userSignUpResponse.setFirstName(firstName);
        userSignUpResponse.setLastName(lastName);
        userSignUpResponse.setPhoneNo(phoneNo);
        userSignUpResponse.setEmailId(emailId);
        userSignUpResponse.setVpa(vpa);
        userSignUpResponse.setBalanceAmount(balance);
        return userSignUpResponse;
    }
}
