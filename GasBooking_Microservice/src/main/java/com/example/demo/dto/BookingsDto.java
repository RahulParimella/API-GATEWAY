package com.example.demo.dto;



import java.time.LocalDate;

public class BookingsDto {

	private int gasbookingId;

	private LocalDate bookingDate;

	private boolean status;

	private float bill;
	
	

	public BookingsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGasbookingId() {
		return gasbookingId;
	}

	public void setGasbookingId(int gasbookingId) {
		this.gasbookingId = gasbookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}
	

}
