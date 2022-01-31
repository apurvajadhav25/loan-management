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
import com.demo.model.Customer;
import com.demo.repositoy.CustomerRepository;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public  Iterable<Customer> getAllCustomers(){
		return  customerRepository.findAll();
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	    }
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Integer id) {
	     Customer customer = customerRepository.findById(id).get();
	     customerRepository.delete(customer);
	     return "Product with id  "+id+" deleted successfully";
	    }
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Integer id) {
		return customerRepository.findById(id).get();	
	}
	
	@PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateFilter1(@PathVariable(value = "id") Integer id,
                                                 @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id).get();

        customer.setName(customerDetails.getName());
        customer.setMobileNumber(customerDetails.getMobileNumber());
        customer.setIsActive(customer.getIsActive());
        customer.setEmailId(customer.getEmailId());
        customer.setAddress(customer.getAddress());
        
        final Customer updatedcustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedcustomer);
    }

}
