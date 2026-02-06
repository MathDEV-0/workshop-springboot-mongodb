package com.math_dev.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.math_dev.workshopmongo.domain.User;
import com.math_dev.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> findAll(){
	    List<User> list = userRepo.findAll();
	    return list;
	}

}
