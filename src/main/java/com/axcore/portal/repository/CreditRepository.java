package com.axcore.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axcore.portal.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
	// Add custom query methods if needed
}
