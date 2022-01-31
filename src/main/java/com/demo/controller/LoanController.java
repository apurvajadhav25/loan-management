package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Loan;
import com.demo.repositoy.LoanRepository;

@RestController
@CrossOrigin
public class LoanController {
	
	@Autowired
	LoanRepository loanRepository;
	
	@GetMapping("/loan")
	public  Iterable<Loan> getAllLoan(){
		return  loanRepository.findAll();
	}
	
	@PostMapping("/loan")
	public Loan createLoan(@RequestBody Loan loan) {
		return loanRepository.save(loan);
	    }
	
	@DeleteMapping("/loan/{id}")
	public String deleteLoan(@PathVariable(value = "id") Integer id) {
	     Loan loan = loanRepository.findById(id).get();
	     loanRepository.delete(loan);
	     return "Product with id  "+id+" deleted successfully";
	    }
	
	@GetMapping("/loan/{id}")
	public Loan getLoanById(@PathVariable(value = "id") Integer id) {
		return loanRepository.findById(id).get();	
	}
	
	@PutMapping("/loan/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Integer id,
                                                 @RequestBody Loan loanDetails) {
        Loan loan = loanRepository.findById(id).get();

        loan.setAccountNumber(loanDetails.getAccountNumber());
        loan.setBalanceTenure(loanDetails.getBalanceTenure());
        loan.setCustomer(loanDetails.getCustomer());
        loan.setDescription(loanDetails.getDescription());
        loan.setDueOn(loanDetails.getDueOn());
        loan.setEmi(loanDetails.getEmi());
        loan.setFirstDisbursal(loanDetails.getFirstDisbursal());
        loan.setInstallmentFrequency(loanDetails.getInstallmentFrequency());
        loan.setLastDisbursal(loanDetails.getLastDisbursal());
        loan.setOutStandingAmount(loanDetails.getOutStandingAmount());
        loan.setRateOfInterest(loanDetails.getRateOfInterest());
        loan.setTenure(loanDetails.getTenure());
        loan.setTotalAmount(loanDetails.getTotalAmount());
        
        final Loan updatedLoan = loanRepository.save(loan);
        return ResponseEntity.ok(updatedLoan);
    }


}
