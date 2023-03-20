package com.web.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.entity.Customer;
import com.web.demo.repo.CustomerRepo;

@RestController
public class CustomerContoller {
	@Autowired
	CustomerRepo repo;
	
	//POST
	//Register bus
	@PostMapping("/busreservation/register/user")
	public ResponseEntity<Customer>save (@RequestBody Customer customer)
	{
		try {
			
			return new ResponseEntity<>(repo.save(customer),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Book a trip
	@PostMapping("/busreservation/register/user/{trip_id}")
	public ResponseEntity<Customer>save1 (@RequestBody Customer customer)
	{
		try {
			
			return new ResponseEntity<>(repo.save(customer),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//GET
	//Get all the trips
	@GetMapping("/busreservation/trip")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		try
		{
			List<Customer> list = repo.findAll();
			if(list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		}catch(Exception e){
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	
	//GET 
	//To Get specific trip using id 

	@GetMapping("/login/{trip_id}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable Long trip_id )
	{
		Optional<Customer> customer = repo.findById(trip_id);
		
		if(customer.isPresent())
		{
			return new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	
	
	}
	
	//PUT
	//Update user
@PutMapping("/busreservation/updateuser/{trip_id}")
	
	public   ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
		try {
			return new ResponseEntity<Customer>(repo.save(customer),HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
//DELETE
//Delete user
	@DeleteMapping("busreservation/canceltrip/{trip_id}")
	public ResponseEntity<HttpStatus> cancelCustomer(@PathVariable Long trip_id){
		try
		{
			Optional<Customer> customer = repo.findById(trip_id);
			if(customer.isPresent())
					{
			repo.delete(customer.get());
				
				}
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
					}catch(Exception e) {
						return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
	}
	
	
	
	
}


