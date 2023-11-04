package com.Infy.WeCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Infy.WeCare.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
}
