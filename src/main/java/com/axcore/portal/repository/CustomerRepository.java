package com.axcore.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axcore.portal.entity.Course;
import com.axcore.portal.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}