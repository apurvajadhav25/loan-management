package com.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Bounces;
import com.demo.model.Loan;
import com.demo.repositoy.BouncesRepository;
import com.demo.repositoy.LoanRepository;

@RestController
@CrossOrigin
public class BouncesController {
	
	@Autowired
	BouncesRepository bouncesRepository;
	
	@Autowired
	LoanRepository loanRepository;
	
	@GetMapping("/bounces")
	public  Iterable<Bounces> getAllBounce() {
		return  bouncesRepository.findAll();
	}
	
	@PostMapping("/bounces")
	public Bounces createBounce(@RequestBody Bounces bounce,
			                    @RequestParam("accountNumber") String accountNumber) {
		System.out.println(accountNumber);
		Loan loan = loanRepository.findLoanByAccountNumber(accountNumber);
		bounce.setLoan(loan);
		return bouncesRepository.save(bounce);
	    }
	
	@DeleteMapping("/bounces/{id}")
	public String deleteBounce(@PathVariable(value = "id") Integer id) {
	     Bounces bounces = bouncesRepository.findById(id).get();
	     bouncesRepository.delete(bounces);
	     return "Product with id  "+id+" deleted successfully";
	    }
	
	@GetMapping("/bounces/{id}")
	public Bounces getBounceById(@PathVariable(value = "id") Integer id) {
		return bouncesRepository.findById(id).get();	
	}
	
	@PutMapping("/bounces/{id}")
    public ResponseEntity<Bounces> updateBounce(@PathVariable(value = "id") Integer id,
                                                 @RequestBody Bounces bounceDetails,
                                                 @RequestParam("accountNumber") String accountNumber) {
		System.out.println(accountNumber);
	
		Loan loan = loanRepository.findLoanByAccountNumber(accountNumber);
		System.out.println(loan);
		bounceDetails.setLoan(loan);
        Bounces bounce = bouncesRepository.findById(id).get();

        bounce.setDate(bounceDetails.getDate());
        bounce.setLoan(loan);
        
        final Bounces updatedLoan = bouncesRepository.save(bounce);
        return ResponseEntity.ok(updatedLoan);
    }

}
