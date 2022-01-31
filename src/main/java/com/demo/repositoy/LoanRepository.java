package com.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
