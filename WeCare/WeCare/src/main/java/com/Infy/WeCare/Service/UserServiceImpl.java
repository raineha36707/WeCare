package com.Infy.WeCare.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Infy.WeCare.DTO.UserDTO;
import com.Infy.WeCare.Entity.User;
import com.Infy.WeCare.Exception.NoSuchUser;
import com.Infy.WeCare.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDTO addUser(UserDTO user) {
		User perUser = new User(user);
		repo.save(perUser);
		user = new UserDTO(perUser);
		return user;
	}

	@Override
	public UserDTO getProfile(int id) throws NoSuchUser {
		if (isUserPresent(id)) {
			Optional<User> opt = repo.findById(id);
			User temp = opt.get();
			return new UserDTO(temp);
		}
		throw new NoSuchUser("No such User found by this id.");
		
	}

	@Override
	public boolean loginUser(UserDTO userDto) {
		// TODO Auto-generated method stub
		// if present =>true
		return false;
	}

	@Override
	public boolean isUserPresent(int id) {
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}
	
	
	
 
}
