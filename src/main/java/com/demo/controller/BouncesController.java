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
import com.demo.model.Bounces;
import com.demo.repositoy.BouncesRepository;

@RestController
@CrossOrigin
public class BouncesController {
	
	@Autowired
	BouncesRepository bouncesRepository;
	
	@GetMapping("/bounces")
	public  Iterable<Bounces> getAllBounce(){
		return  bouncesRepository.findAll();
	}
	
	@PostMapping("/bounces")
	public Bounces createBounce(@RequestBody Bounces bounce) {
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
                                                 @RequestBody Bounces bounceDetails) {
        Bounces bounce = bouncesRepository.findById(id).get();

        bounce.setDate(bounceDetails.getDate());
        bounce.setLoan(bounceDetails.getLoan());
        
        final Bounces updatedLoan = bouncesRepository.save(bounce);
        return ResponseEntity.ok(updatedLoan);
    }

}
