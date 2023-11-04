package com.Infy.WeCare.Service;

import java.util.List;

import com.Infy.WeCare.DTO.CoachDTO;
import com.Infy.WeCare.Exception.NoSuchCoach;

public interface CoachService {
	public boolean isCoachPresent(int id);
	public CoachDTO addCoach(CoachDTO coach);
	public CoachDTO getProfile(int id) throws NoSuchCoach;
	public List<CoachDTO> allCoaches();
}
