package com.example.sb_stored_procedure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sb_stored_procedure.models.CustomerCustom;
import com.example.sb_stored_procedure.service_impls.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl custService;
	
	@GetMapping(value="{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerCustom> findCustomCustomerById(@PathVariable("id")Long id){
		CustomerCustom customer = custService.findCustomCustomerById(id);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	
}
