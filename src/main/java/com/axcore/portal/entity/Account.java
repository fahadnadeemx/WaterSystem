package com.axcore.portal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "transaction_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "transaction_date", nullable = false)
	private LocalDate transactionDate;

	@Column(name = "description")
	private String description;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "fee_submission_id")
//	private FeeSubmission feeSubmission;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "teacher_salary_id")
//	private TeacherSalarySubmission teacherSalarySubmission;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expense_id")
	private Expense expense;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_id")
	private Credit credit;

	public enum TransactionType {
		CREDIT, DEBIT
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public FeeSubmission getFeeSubmission() {
//		return feeSubmission;
//	}
//
//	public void setFeeSubmission(FeeSubmission feeSubmission) {
//		this.feeSubmission = feeSubmission;
//	}
//
//	public TeacherSalarySubmission getTeacherSalarySubmission() {
//		return teacherSalarySubmission;
//	}
//
//	public void setTeacherSalarySubmission(TeacherSalarySubmission teacherSalarySubmission) {
//		this.teacherSalarySubmission = teacherSalarySubmission;
//	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

}
