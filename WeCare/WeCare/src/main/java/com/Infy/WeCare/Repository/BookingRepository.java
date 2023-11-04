package com.Infy.WeCare.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Infy.WeCare.Entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	public List<Booking> findByUserId(int id);
	public List<Booking> findByCoachId(int id);

}
