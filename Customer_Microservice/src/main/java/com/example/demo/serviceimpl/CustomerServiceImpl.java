package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.BookingClient;
import com.example.demo.dto.BookingsDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private BookingClient bookingClient;

	@Override
	public CustomerDto addCustomers(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer customer=modelMapper.map(customerDto, Customer.class);
		Customer save=custRepo.save(customer);
		CustomerDto customerDtos=modelMapper.map(save, CustomerDto.class);
		return customerDtos;
	}

	@Override
	public List<CustomerDto> viewAll() {
		// TODO Auto-generated method stub
		List<Customer> list=custRepo.findAll();
		return list.stream()
                .map(customers -> modelMapper.map(customers, CustomerDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public CustomerDto getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Customer customer=custRepo.findById(customerId).get();
		CustomerDto customerDto=modelMapper.map(customer, CustomerDto.class);
		List<BookingsDto> bookingsList=bookingClient.getBookingsList();
		customerDto.setBookingsDtoList(bookingsList);
		return customerDto;
	}

	@Override
	public String update(int customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Optional<Customer> cy = custRepo.findById(customerId);
		if (cy.isPresent()) {
			Customer updateCustomer = cy.get();
			updateCustomer.setAccountNo(customerDto.getAccountNo());
			updateCustomer.setIfscNo(customerDto.getIfscNo());
			updateCustomer.setPan(customerDto.getPan());
			//updateCustomer.setCustomerId(customerDto.getCustomerId());

			custRepo.save(updateCustomer);
			return "updated Successfully";

		} else {
			// new CustomerNotFoundException("customerId id not found:" + customerId);
			return "UserId not Found";
		}
	}

//	@Override
//	public CustomerDto getCustomerById(int customerId) {
//		// TODO Auto-generated method stub
//		Customer customer=custRepo.findById(customerId).get();
//		CustomerDto customerDto=modelMapper.map(customer, CustomerDto.class);
//		BookingsDto bookingDto=bookingClient.getByIdBookings(customerId);
//		//List<BookingsDto> bookingsDtoList=bookingClient.getBookingsByCustomerId(customerId);
//		customerDto.setBookingDto(bookingDto);
//		//customerDto.setBookingsDtoList(bookingsDtoList);
//		return customerDto;
//	}
	

}
