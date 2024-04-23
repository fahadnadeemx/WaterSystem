package com.axcore.portal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.axcore.portal.entity.Account;
import com.axcore.portal.entity.Account.TransactionType;
import com.axcore.portal.service.AccountServiceImpl;

@Controller
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/accounts")
    public String showAccounts(Model model) {
        // Get all accounts from the service
        List<Account> accounts = accountService.getAllAccounts();

        // Calculate total balance
        BigDecimal totalBalance = calculateTotalBalance(accounts);

        // Add accounts and total balance to the model
        model.addAttribute("accounts", accounts);
        model.addAttribute("totalBalance", totalBalance);

        // Return the name of the Thymeleaf template to render
        return "pages/accounts";
    }

    private BigDecimal calculateTotalBalance(List<Account> accounts) {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account account : accounts) {
            if (account.getTransactionType() == TransactionType.CREDIT) {
                totalBalance = totalBalance.add(account.getAmount());
            } else {
                totalBalance = totalBalance.subtract(account.getAmount());
            }
        }
        return totalBalance;
    }
}
