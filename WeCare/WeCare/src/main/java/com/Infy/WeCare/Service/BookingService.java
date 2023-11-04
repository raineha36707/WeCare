package com.Infy.WeCare.Service;

import java.time.LocalDate;
import java.util.List;

import com.Infy.WeCare.DTO.BookingDTO;
import com.Infy.WeCare.Exception.NoSuchBooking;
import com.Infy.WeCare.Exception.WecareException;

public interface BookingService {
	public boolean isBookingPresent(int id);
	public boolean bookAppointment(String userId, String coachId, String slot, LocalDate dateOfAppointment) throws WecareException;
	public boolean rescheduleAppointment( Integer bookingId, String slot, LocalDate dateOfAppointment) throws WecareException;
	public void cancelAppointment(Integer bookingId) throws WecareException;
	public BookingDTO findByBookingId(Integer bookingId) throws NoSuchBooking;
	public List<BookingDTO> findBookingByUserId(String userId) throws WecareException;
	public List<BookingDTO> findBookingByCoachId(String coachId) throws WecareException;
}
