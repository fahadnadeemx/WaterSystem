package com.axcore.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axcore.portal.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	// Add custom query methods if needed
}
