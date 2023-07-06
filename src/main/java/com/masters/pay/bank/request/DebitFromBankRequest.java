package com.masters.pay.bank.request;

import lombok.Data;

@Data
public class DebitFromBankRequest {
    private String emailId;
    private Long amount;
}
