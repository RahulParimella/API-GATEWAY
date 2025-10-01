package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public CustomerDto addCustomers(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomers(customerDto);
		
	}
	
	@GetMapping("/customerList")
	public List<CustomerDto> getCustomerList(){
		List<CustomerDto> list=customerService.viewAll();
		return list;
	}
	
	@GetMapping("/customer/{customerId}")
	public CustomerDto getById(@PathVariable("customerId") int customerId) {
		return customerService.getCustomerById(customerId);
		
	}
	@PutMapping("/update/{customerId}")
	public String updateById(@PathVariable("customerId") int customerId,@RequestBody CustomerDto customerDto) {
		return customerService.update(customerId, customerDto);
		
	}
}
