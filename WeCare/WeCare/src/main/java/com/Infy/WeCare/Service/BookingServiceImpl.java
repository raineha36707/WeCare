package com.Infy.WeCare.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Infy.WeCare.DTO.BookingDTO;
import com.Infy.WeCare.Entity.Booking;
import com.Infy.WeCare.Exception.InvalidDate;
import com.Infy.WeCare.Exception.NoSuchBooking;
import com.Infy.WeCare.Exception.NoSuchCoach;
import com.Infy.WeCare.Exception.NoSuchUser;
import com.Infy.WeCare.Exception.WecareException;
import com.Infy.WeCare.Repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository repo;

	@Autowired
	UserService userService;

	@Autowired
	CoachService coachService;
	
	@Override
	public boolean bookAppointment(String userId, String coachId, String slot, LocalDate dateOfAppointment) throws WecareException {
		int user = Integer.parseInt(userId);
		if (!userService.isUserPresent(user)) {
			throw new NoSuchUser("No such User found by this id. Enter valid userID to bookAppointment");
		}
		int coach = Integer.parseInt(coachId);
		if (!coachService.isCoachPresent(user)) {
			throw new NoSuchUser("No such Coach found by this id. Enter valid userID to bookAppointment");
		}
		if(!isValidDate(dateOfAppointment)) {
			throw new InvalidDate("Date not Valid");
		}
		Booking book = new Booking();
		book.setUserId(user);
		book.setCoachId(coach);
		book.setSlot(slot); // add availability logic
		book.setAppointmentDate(dateOfAppointment);
		return true;
	}

	@Override
	public boolean rescheduleAppointment(Integer bookingId, String slot, LocalDate dateOfAppointment) throws WecareException{
		if (isBookingPresent(bookingId)) {
			if(!isValidDate(dateOfAppointment))  // If Not Valid Date
				throw new InvalidDate("Date of appointment is invalid");
			Booking book = repo.findById(bookingId).get();
			book.setSlot(slot);
			book.setAppointmentDate(dateOfAppointment);
			return true;
		}
		throw new NoSuchUser("No such Booking found for rescheduling");
	}

	@Override
	public void cancelAppointment(Integer bookingId) throws NoSuchBooking{
		if (isBookingPresent(bookingId)) {
			repo.deleteById(bookingId);
		}
		throw new NoSuchBooking("No Such Booking Found");
	}

	@Override
	public BookingDTO findByBookingId(Integer bookingId) throws NoSuchBooking{
		if (isBookingPresent(bookingId) ) {
			Optional<Booking> opt = repo.findById(bookingId);
			BookingDTO b = new BookingDTO(opt.get());
			return b;
		}
		throw new NoSuchBooking("Booking not found");
	}

	@Override
	public List<BookingDTO> findBookingByUserId(String userId) throws WecareException{
		int id = Integer.parseInt(userId);
		if (!userService.isUserPresent(id))  {
			throw new NoSuchUser("No such user found");
		}
		List<BookingDTO> dto = new ArrayList<>();
		List<Booking> booking =  repo.findByUserId(id);
		booking.forEach((book) -> dto.add(new BookingDTO(book)));
		return dto;
	}

	@Override
	public List<BookingDTO> findBookingByCoachId(String coachId) throws WecareException{
		int id = Integer.parseInt(coachId);
		if (!coachService.isCoachPresent(id)) 
			throw new NoSuchCoach("No such coach found");
		List<BookingDTO> dto = new ArrayList<>();
		List<Booking> booking =  repo.findByCoachId(id);
		booking.forEach((book) -> dto.add(new BookingDTO(book)));
		return dto;
	}

	@Override
	public boolean isBookingPresent(int id){
		Optional<Booking> opt = repo.findById(id);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}
	
	public boolean isValidDate(LocalDate date) {
		LocalDate now = LocalDate.now();
		if (date.isAfter(now.plusWeeks(1)) && date.isBefore(now)) {
			return false;
		}
		return true;
	}

}
