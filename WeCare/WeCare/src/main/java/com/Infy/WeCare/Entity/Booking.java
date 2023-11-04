package com.Infy.WeCare.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Infy.WeCare.DTO.BookingDTO;
@Entity
@Table(name="bookingtable")
public class Booking {
	
	public Booking() {}

	public Booking(BookingDTO booking) {
		this.bookingId = booking.getBookingId();
		this.coachId = booking.getCoachId();
		this.userId = booking.getUserId();
		this.appointmentDate = LocalDate.parse(booking.getAppointmentDate());
		this.slot = booking.getSlot();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private int userId;
	private int coachId;
	private LocalDate appointmentDate;
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
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", coachId=" + coachId + ", appointmentDate="
				+ appointmentDate + ", slot=" + slot + "]";
	}
	
}
