package com.axcore.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Credit;
import com.axcore.portal.repository.CreditRepository;

@Service
public class CreditServiceImpl {
	@Autowired
	private CreditRepository creditRepository;

	public List<Credit> getAllCredit() {
		return creditRepository.findAll();
	}

	public Credit getCreditById(Long id) {
		return creditRepository.findById(id).orElse(null);
	}

	public Credit saveOrUpdateCredit(Credit credit) {
		return creditRepository.save(credit);
	}

	public void deleteCredit(Long id) {
		creditRepository.deleteById(id);
	}
}
