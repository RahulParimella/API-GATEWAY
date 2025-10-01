package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingsDto;
import com.example.demo.entity.Bookings;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookingsDto addBookings(BookingsDto bookingsDto) {
		// TODO Auto-generated method stub
		Bookings bookings = modelMapper.map(bookingsDto, Bookings.class);
		Bookings saveBookings = bookingRepo.save(bookings);
		BookingsDto bookingDtos = modelMapper.map(saveBookings, BookingsDto.class);
		return bookingDtos;
	}

	@Override
	public BookingsDto getById(int gasbookingId) {
		// TODO Auto-generated method stub
		Bookings bookings = bookingRepo.findById(gasbookingId).get();
		BookingsDto bookingsDto = modelMapper.map(bookings, BookingsDto.class);
		return bookingsDto;
	}

//	@Override
//	public List<BookingsDto> getBookingsIdsByCustomerId(int gasbookingId) {
//		// TODO Auto-generated method stub
//		Optional<Bookings> optionalBookings = bookingRepo.findById(gasbookingId);
//
//		if (optionalBookings.isPresent()) {
//			// Assuming there's a method to convert Bookings entity to BookingsDto
//			BookingsDto bookingsDto = modelMapper.map(optionalBookings, BookingsDto.class);
//
//			// Assuming you want to return a list with a single element
//			return Collections.singletonList(bookingsDto);
//		} else {
//			// Handle the case where the booking with the given ID is not found
//			return Collections.emptyList();
//		}
//	}

	@Override
	public List<BookingsDto> saveBookings(int bookingId, List<BookingsDto> bookingsDtoList) {
		List<Bookings> bookingsList = bookingsDtoList.stream().map(dto -> {
			Bookings entity = modelMapper.map(dto, Bookings.class);
			entity.setGasbookingId(bookingId); // Associate the booking with the provided bookingId
			return entity;
		}).collect(Collectors.toList());

		List<Bookings> savedBookings = bookingRepo.saveAll(bookingsList);

		return savedBookings.stream().map(entity -> modelMapper.map(entity, BookingsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookingsDto> viewAll() {
		// TODO Auto-generated method stub
		List<Bookings> list=bookingRepo.findAll();
		return list.stream()
                .map(bookings -> modelMapper.map(bookings, BookingsDto.class))
                .collect(Collectors.toList());
	}

}
