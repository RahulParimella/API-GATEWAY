package com.example.demo.dto;

import java.util.List;

public class CustomerDto {

	private int customerId;
	private int accountNo;
	private String ifscNo;
	private String pan;
	
	//private BookingsDto bookingDto;
	
    private List<BookingsDto> bookingsDtoList;

 
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
public CustomerDto(int accountNo, String ifscNo, String pan, List<BookingsDto> bookingsDtoList) {
		super();
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
		this.bookingsDtoList = bookingsDtoList;
	}



//	public CustomerDto(int accountNo, String ifscNo, String pan, BookingsDto bookingDto) {
//		super();
//		this.accountNo = accountNo;
//		this.ifscNo = ifscNo;
//		this.pan = pan;
//		this.bookingDto = bookingDto;
//	}

	public int getCustomerId() {
		return customerId;
	}

	

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}


//
//	public BookingsDto getBookingDto() {
//		return bookingDto;
//	}
//
//
//
//	public void setBookingDto(BookingsDto bookingDto) {
//		this.bookingDto = bookingDto;
//	}



	public List<BookingsDto> getBookingsDtoList() {
        return bookingsDtoList;
    }

    public void setBookingsDtoList(List<BookingsDto> bookingsDtoList) {
        this.bookingsDtoList = bookingsDtoList;
    }
	
	
}
