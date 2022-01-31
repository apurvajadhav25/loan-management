package com.demo.model;

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
	String totalAmount;
	String outStandingAmount;
	String tenure;
	String balanceTenure;
	String emi;
	String description;
	String rateOfInterest;
	String installmentFrequency;
	String firstDisbursal;
	String lastDisbursal;
	String dueOn;
	
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

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOutStandingAmount() {
		return outStandingAmount;
	}

	public void setOutStandingAmount(String outStandingAmount) {
		this.outStandingAmount = outStandingAmount;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getBalanceTenure() {
		return balanceTenure;
	}

	public void setBalanceTenure(String balanceTenure) {
		this.balanceTenure = balanceTenure;
	}

	public String getEmi() {
		return emi;
	}

	public void setEmi(String emi) {
		this.emi = emi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getInstallmentFrequency() {
		return installmentFrequency;
	}

	public void setInstallmentFrequency(String installmentFrequency) {
		this.installmentFrequency = installmentFrequency;
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

	public String getDueOn() {
		return dueOn;
	}

	public void setDueOn(String dueOn) {
		this.dueOn = dueOn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
