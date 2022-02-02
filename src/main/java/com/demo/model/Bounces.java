package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bounces {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int id;
	Date date;
	
	
	@ManyToOne
	Loan loan;
	
	public Bounces() {
	}
	
	

	public Bounces(int id, Date date, Loan loan) {
		super();
		this.id = id;
		this.date = date;
		this.loan = loan;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
}
