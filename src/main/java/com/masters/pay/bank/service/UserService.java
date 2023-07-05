package com.masters.pay.bank.service;

import com.masters.pay.bank.dao.User;
import com.masters.pay.bank.repository.UserRepo;
import com.masters.pay.bank.request.UserLogInRequest;
import com.masters.pay.bank.request.UserSignUpRequest;
import com.masters.pay.bank.response.BaseResponse;
import com.masters.pay.bank.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public BaseResponse userSignUp(UserSignUpRequest userSignUpRequest) {
        log.info("Signing Up the user : " + userSignUpRequest.toString());
        try {
            validateUserSignUpRequest(userSignUpRequest);
            List<User> resultSet = userRepo.findByUsername(userSignUpRequest.getUsername());
            if (resultSet.isEmpty()) {
                User user = new User();
                user.setUsername(userSignUpRequest.getUsername());
                user.setFirstName(userSignUpRequest.getFirstName());
                user.setLastName(userSignUpRequest.getLastName());
                user.setEmailId(userSignUpRequest.getEmailId());
                user.setPassword(userSignUpRequest.getPassword());
                user.setPhoneNo(userSignUpRequest.getPhoneNo());
                user.setVpa(createVpa(userSignUpRequest.getPhoneNo()));
                userRepo.save(user);
                log.info("User Sign Up Successful");
                return UserUtil.getBaseResponse("200", "User Signup Successful");
            } else {
                log.info("Username already exists");
                return UserUtil.getBaseRepWithFailedStatus("400", "Username already exists");
            }
        } catch (ValidationException e) {
            log.error("Validation Exception >>> " + e.getMessage());
            return UserUtil.getBaseRepWithFailedStatus("400", e.getMessage());
        }
    }

    private String createVpa(String phoneNo) {
        StringBuilder sb = new StringBuilder()
                .append(phoneNo)
                .append("@bank");
        return sb.toString();
    }

    public BaseResponse userLogin(UserLogInRequest userLoginRequest) {
        log.info("Loging in the user" + userLoginRequest.toString());
        try {
            validateUserLoginRequest(userLoginRequest);
            List<User> resultSet = userRepo.findByUsername(userLoginRequest.getUsername());
            if (resultSet.isEmpty()) {
                log.error("User not registered");
                return UserUtil.getBaseRepWithFailedStatus("400", "User not registered");
            } else if (!resultSet.get(0).getPassword().equals(userLoginRequest.getPassword())) {
                log.error("Password incorrect");
                return UserUtil.getBaseRepWithFailedStatus("400", "Password incorrect");
            } else {
                log.info("Login Successful");
                return UserUtil.getBaseResponse("200", "Login Successful");
            }
        } catch (ValidationException e) {
            log.error("Validation Exception >>> " + e.getMessage());
            return UserUtil.getBaseRepWithFailedStatus("400", e.getMessage());
        }
    }

    private void validateUserSignUpRequest(UserSignUpRequest userSignUpRequest) throws ValidationException {
        if (!StringUtils.hasText(userSignUpRequest.getUsername())) {
            throw new ValidationException("Username Missing");
        }
        if (!StringUtils.hasText(userSignUpRequest.getFirstName())) {
            throw new ValidationException("First name Missing");
        }
        if (!StringUtils.hasText(userSignUpRequest.getLastName())) {
            throw new ValidationException("Last name missing");
        }
        if (!StringUtils.hasText(userSignUpRequest.getPassword())) {
            throw new ValidationException("Password Missing");
        }
        if (!StringUtils.hasText(userSignUpRequest.getEmailId())) {
            throw new ValidationException("Email Missing");
        }
        if (!StringUtils.hasText(userSignUpRequest.getPhoneNo())) {
            throw new ValidationException("Phone No Missing");
        }
    }

    private void validateUserLoginRequest(UserLogInRequest userLoginRequest) throws ValidationException {
        if (!StringUtils.hasText(userLoginRequest.getUsername())) {
            throw new ValidationException("Username missing");
        }
        if (!StringUtils.hasText(userLoginRequest.getPassword())) {
            throw new ValidationException("Password Missing");
        }
    }
}
