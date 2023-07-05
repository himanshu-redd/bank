package com.masters.pay.bank.util;


import com.masters.pay.bank.response.BaseResponse;

public class UserUtil {

    public static BaseResponse getBaseRepWithFailedStatus(String code , String message){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("FALSE");
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    public static BaseResponse getBaseResponse(String code, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("TRUE");
        baseResponse.setCode(code);
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
