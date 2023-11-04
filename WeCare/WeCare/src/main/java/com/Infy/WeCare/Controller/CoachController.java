package com.Infy.WeCare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Infy.WeCare.DTO.CoachDTO;
import com.Infy.WeCare.Exception.NoSuchCoach;
import com.Infy.WeCare.Service.CoachService;

@RestController
public class CoachController {
	
	@Autowired
	CoachService service;
	
	@PostMapping("/coaches") 
	public CoachDTO createCoach(@RequestBody CoachDTO dto) {
		return service.addCoach(dto);
	}
	
	@GetMapping("/coaches/{id}")
	public CoachDTO getCoachProfile(@PathVariable int id) throws NoSuchCoach {
		return service.getProfile(id);
	}
	
	@GetMapping("coaches/all")
	public List<CoachDTO> showAllCoaches() {
		return service.allCoaches();
	}
	
}
