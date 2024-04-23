package com.axcore.portal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axcore.portal.entity.Account;
import com.axcore.portal.entity.Credit;
import com.axcore.portal.service.AccountServiceImpl;
import com.axcore.portal.service.CreditServiceImpl;

@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditServiceImpl creditService;

    @Autowired
    private AccountServiceImpl accountService; 

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("creditForm", new Credit()); // Renamed to avoid conflict
        model.addAttribute("credits", creditService.getAllCredit()); // Added credits attribute
        return "pages/create-credit";
    }

    @PostMapping("/add")
    public String addCredit(@ModelAttribute("creditForm") Credit credit) {
        // Save the credit
        credit = creditService.saveOrUpdateCredit(credit);

        // Create a new Account instance
        Account account = new Account();
        account.setTransactionType(Account.TransactionType.CREDIT);
        account.setAmount(credit.getAmount());
        account.setTransactionDate(LocalDate.now());
        account.setDescription("We've Received: " + credit.getDescription());

        // Set the credit in the account
        account.setCredit(credit);

        // Save the account
        accountService.saveOrUpdateAccount(account);

        return "redirect:/credit"; // Changed the redirect URL
    }
}
