package com.axcore.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axcore.portal.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}
