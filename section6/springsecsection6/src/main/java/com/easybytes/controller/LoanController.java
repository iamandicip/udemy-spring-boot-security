package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/myLoans")
    public String getLoanDetails() {
        return "Here are the loans details from the DB";
    }
}
