package com.masters.pay.bank.controller;

import com.masters.pay.bank.request.DebitFromBankRequest;
import com.masters.pay.bank.response.DebitFromBankResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/bank")
public class TransactionController {
    @PostMapping(path = "/debit", produces = MediaType.APPLICATION_JSON_VALUE)
    public DebitFromBankResponse debitFromBank(@RequestBody DebitFromBankRequest debitFromBankRequest){
        log.info("Debit from bank request received");
        DebitFromBankResponse response = new DebitFromBankResponse();
        response.setMessage("asljf");
        response.setStatus("200");
        return response;
    }
}
