package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto addCustomers(CustomerDto customerDto);
	List<CustomerDto> viewAll();
	CustomerDto getCustomerById(int customerId );
	String update(int customerId,CustomerDto customerDto);
}
