package com.Infy.WeCare.Service;

import com.Infy.WeCare.DTO.UserDTO;
import com.Infy.WeCare.Exception.NoSuchUser;

public interface UserService {
	public boolean isUserPresent(int id);
	public UserDTO addUser(UserDTO user);
	public UserDTO getProfile(int id) throws NoSuchUser;
	public boolean loginUser(UserDTO user);
}
