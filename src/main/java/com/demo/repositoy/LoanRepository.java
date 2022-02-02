package com.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
	@Query("SELECT l FROM Loan l WHERE l.accountNumber = :accountNumber")
	Loan findLoanByAccountNumber(@Param("accountNumber") String accountNumber);

}
