package com.Infy.WeCare.DTO;

import com.Infy.WeCare.Entity.Booking;

public class BookingDTO {
	
	public BookingDTO() {}
	
	public BookingDTO(Booking booking) {
		this.bookingId = booking.getBookingId();
		this.coachId = booking.getCoachId();
		this.userId = booking.getUserId();
		this.appointmentDate = booking.getAppointmentDate().toString();
		this.slot = booking.getSlot();
	}
	
	private int bookingId;
	
	private int userId;
	private int coachId;
	private String appointmentDate;
	private String slot;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
}
