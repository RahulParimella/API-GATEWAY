package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingsDto;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/saveBookings")
	public BookingsDto addBookings(@RequestBody BookingsDto bookingDto) {

		return bookingService.addBookings(bookingDto);

	}

	@GetMapping("/bookings/{gasbookingId}")
	public BookingsDto getByIdBookings(@PathVariable("gasbookingId") int gasbookingId) {
		BookingsDto bookingDto = bookingService.getById(gasbookingId);
		return bookingDto;

	}
//
//	@GetMapping("/getAllbookings/{gasbookingId}")
//	public List<BookingsDto> getBookingsIdsByCustomerId(@PathVariable("gasbookingId") int gasbookingId) {
//		List<BookingsDto> bookingsDtoList = bookingService.getBookingsIdsByCustomerId(gasbookingId);
//		return bookingsDtoList;
//	}
	
	@GetMapping("/getAllbookings")
	public List<BookingsDto> getBookingsList(){
		List<BookingsDto> list=bookingService.viewAll();
		return list;
	}

//	@PostMapping("/save")
//    public List<BookingsDto> saveBookings(@RequestBody List<BookingsDto> bookingsDtoList) {
//        List<BookingsDto> savedBookings = bookingService.saveBookings(bookingsDtoList);
//        return savedBookings;
//    }

	@PostMapping("/save/all/{bookingId}")
	public List<BookingsDto> saveAllBookingsUnderBookingId(@PathVariable int bookingId,
			@RequestBody List<BookingsDto> bookingsDtoList) {
		List<BookingsDto> savedBookings = bookingService.saveBookings(bookingId, bookingsDtoList);
		return savedBookings;
	}

}
