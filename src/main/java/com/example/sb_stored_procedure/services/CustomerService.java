package com.example.sb_stored_procedure.services;

import com.example.sb_stored_procedure.models.CustomerCustom;

public interface CustomerService {
	
	// Retrieve single object of customer with its country by calling procedure
	public CustomerCustom findCustomCustomerById(Long id);
}
