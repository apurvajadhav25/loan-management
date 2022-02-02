package com.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int id;
	String accountNumber;
	String type;
	float roi;
	int frequency;
	double totalAmount;
	double outStandingAmount;
	double tenure;
	double balanceTenure;
	double emiAmount;
	double interestAmount;
	String description;
	String firstDisbursal;
	String lastDisbursal;
	Date dueOn;
	boolean isActive;
	
	@ManyToOne()
	Customer customer;
	
	@OneToMany(mappedBy = "loan")
	Set<Payments> payment;
	
	@OneToMany(mappedBy = "loan")
	Set<Bounces> bounces;
	
	@OneToMany(mappedBy = "loan")
	Set<FutureInstallments> FutureInstallments;
	
	public Loan() {
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRoi() {
		return roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getOutStandingAmount() {
		return outStandingAmount;
	}

	public void setOutStandingAmount(double outStandingAmount) {
		this.outStandingAmount = outStandingAmount;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getBalanceTenure() {
		return balanceTenure;
	}

	public void setBalanceTenure(double balanceTenure) {
		this.balanceTenure = balanceTenure;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirstDisbursal() {
		return firstDisbursal;
	}

	public void setFirstDisbursal(String firstDisbursal) {
		this.firstDisbursal = firstDisbursal;
	}

	public String getLastDisbursal() {
		return lastDisbursal;
	}

	public void setLastDisbursal(String lastDisbursal) {
		this.lastDisbursal = lastDisbursal;
	}

	public Date getDueOn() {
		return dueOn;
	}

	public void setDueOn(Date dueOn) {
		this.dueOn = dueOn;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}
