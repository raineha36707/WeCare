package com.Infy.WeCare.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Infy.WeCare.DTO.CoachDTO;
import com.Infy.WeCare.Entity.Coach;
import com.Infy.WeCare.Exception.NoSuchCoach;
import com.Infy.WeCare.Repository.CoachRepository;

@Service
public class CoachServiceImpl implements CoachService {
	
	@Autowired
	CoachRepository repo;
	
	@Override
	public CoachDTO addCoach(CoachDTO coach) {
		Coach temp = new Coach(coach);
		repo.save(temp);
		return new CoachDTO(temp);
	}

	@Override
	public CoachDTO getProfile(int id) throws NoSuchCoach{
		if (isCoachPresent(id)){
			Optional<Coach> opt = repo.findById(id);
			Coach coach = opt.get();
			return new CoachDTO(coach);
		}
		throw new NoSuchCoach("No coach with such id");
		
	}
	
	@Override
	public List<CoachDTO> allCoaches() {
		List<CoachDTO> dtos = new ArrayList<>();
		Iterable<Coach> itrCoaches = repo.findAll();
		itrCoaches.forEach((temp) -> dtos.add(new CoachDTO(temp)));
		return dtos;
	}

	@Override
	public boolean isCoachPresent(int id) {
		Optional<Coach> opt = repo.findById(id);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}
	
}
