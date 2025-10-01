package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.BookingsDto;

@FeignClient(name = "GasBooking-Microservice", url = "http://localhost:8081/api")
//@FeignClient(name = "GASBOOKING-MICROSERVICE", url = "http://GASBOOKING-MICROSERVICE:8081/api")
public interface BookingClient {
	
//	@GetMapping("/bookings/{gasbookingId}")
//	public BookingsDto getByIdBookings(@PathVariable("gasbookingId") int gasbookingId);
	
//	@GetMapping("/bookings/customer/{customerId}")
//    List<BookingsDto> getBookingsByCustomerId(@PathVariable("customerId") int customerId);

	@GetMapping("/getAllbookings")
	public List<BookingsDto> getBookingsList();
}
