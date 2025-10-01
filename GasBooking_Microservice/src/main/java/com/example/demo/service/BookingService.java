package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BookingsDto;

public interface BookingService {

	BookingsDto addBookings(BookingsDto bookingsDto);

	BookingsDto getById(int gasbookingId);

	//List<BookingsDto> getBookingsIdsByCustomerId(int gasbookingId);

	List<BookingsDto> saveBookings(int bookingId, List<BookingsDto> bookingsDtoList);
	
	List<BookingsDto> viewAll();
}
