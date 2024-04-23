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
import com.axcore.portal.entity.Expense;
import com.axcore.portal.service.AccountServiceImpl;
import com.axcore.portal.service.ExpenseServiceImpl;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseServiceImpl expenseService;

	@Autowired
	private AccountServiceImpl accountService; // Assuming you have AccountService to update account transactions

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("expense", new Expense());
		model.addAttribute("expenses", expenseService.getAllExpenses());
		return "pages/create-expense";
	}

	@PostMapping("/add")
	public String addExpense(@ModelAttribute("expense") Expense expense) {
		// Save the expense
		expense = expenseService.saveOrUpdateExpense(expense);

		// Create a new Account instance
		Account account = new Account();
		account.setTransactionType(Account.TransactionType.DEBIT);
		account.setAmount(expense.getAmount());
		account.setTransactionDate(LocalDate.now());
		account.setDescription("We've Paid: " + expense.getDescription());

		// Set the expense in the account
		account.setExpense(expense);

		// Save the account
		accountService.saveOrUpdateAccount(account);

		return "redirect:/expense";
	}

}
