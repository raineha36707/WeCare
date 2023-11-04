package com.Infy.WeCare.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Infy.WeCare.Exception.WecareException;
import com.Infy.WeCare.Service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@PostMapping("users/{userid}/booking/{coachid}")
	public boolean bookAppointment( @PathVariable String userid, 
									@PathVariable String coachid,
									@RequestParam(name = "slot") String slot,
									@RequestParam(name = "dateOfAppointment") String dateOfAppointment)
									throws WecareException {
		return service.bookAppointment(userid, coachid, slot, LocalDate.parse(dateOfAppointment));	
	}
	
	@PutMapping("booking/{id}")
	public boolean rescheduleAppointment(@PathVariable int id, 
										@RequestParam(name="slot") String slot,
										@RequestParam(name="slot") String dateOfAppointment) 
										throws WecareException{
		return service.rescheduleAppointment(id, slot, LocalDate.parse(dateOfAppointment));
		
	}
	
	@DeleteMapping("booking/{id}")
	public void cancelAppointment(@PathVariable int id) throws WecareException{
		service.cancelAppointment(id);
	}
}
