package com.masters.pay.bank.response;

import lombok.Data;

@Data
public class BaseResponse {
    private String status;
    private String Code;
    private String Message;
}
