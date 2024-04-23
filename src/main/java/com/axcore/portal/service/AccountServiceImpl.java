package com.axcore.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Account;
import com.axcore.portal.repository.AccountRepository;

@Service
public class AccountServiceImpl {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	public Account saveOrUpdateAccount(Account account) {
		return accountRepository.save(account);
	}

	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}
}
