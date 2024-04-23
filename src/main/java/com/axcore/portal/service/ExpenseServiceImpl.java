package com.axcore.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Expense;
import com.axcore.portal.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl {

	@Autowired
	private ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public Expense getExpenseById(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}

	public Expense saveOrUpdateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
