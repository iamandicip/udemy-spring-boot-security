package com.eazybytes.controller;

import com.eazybytes.model.Loans;
import com.eazybytes.repository.CustomerRepository;
import com.eazybytes.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myLoans")
    @PreAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        int id = customerRepository.findByEmail(email).get(0).getId();
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}
