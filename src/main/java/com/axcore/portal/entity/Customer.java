package com.axcore.portal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "bottle_rate")
    private BigDecimal bottleRate;
    @Column(name = "bottle_delivered")
    private int bottleDelivered;
    @Column(name = "empty_bottle_received")
    private int emptyBottleReceived;
    @Column(name = "balanced_bottles")
    private int balancedBottles;
    @Column(name = "received_amount")
    private BigDecimal receivedAmount;
    @Column(name = "balance_amount")
    private BigDecimal balanceAmount;
    @Column(name = "date_of_bottle_delivered")
    private LocalDate dateOfBottleDelivered;

    @ManyToOne
    @JoinColumn(name = "bottle_delivered_by_employee_id")
    private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public BigDecimal getBottleRate() {
		return bottleRate;
	}

	public void setBottleRate(BigDecimal bottleRate) {
		this.bottleRate = bottleRate;
	}

	public int getBottleDelivered() {
		return bottleDelivered;
	}

	public void setBottleDelivered(int bottleDelivered) {
		this.bottleDelivered = bottleDelivered;
	}

	public int getEmptyBottleReceived() {
		return emptyBottleReceived;
	}

	public void setEmptyBottleReceived(int emptyBottleReceived) {
		this.emptyBottleReceived = emptyBottleReceived;
	}

	public int getBalancedBottles() {
		return balancedBottles;
	}

	public void setBalancedBottles(int balancedBottles) {
		this.balancedBottles = balancedBottles;
	}

	public BigDecimal getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(BigDecimal receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public LocalDate getDateOfBottleDelivered() {
		return dateOfBottleDelivered;
	}

	public void setDateOfBottleDelivered(LocalDate dateOfBottleDelivered) {
		this.dateOfBottleDelivered = dateOfBottleDelivered;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// Getters and setters
    
    

}