package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Gasbooking_microservice")
public class Bookings {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int gasbookingId;

	@Column(name="date")
	private LocalDate bookingDate;

	@Column(name="status")
	private boolean status;

	@Column(name="bill")
	private float bill;

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Bookings(LocalDate bookingDate, boolean status, float bill) {
		super();
		this.bookingDate = bookingDate;
		this.status = status;
		this.bill = bill;
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
