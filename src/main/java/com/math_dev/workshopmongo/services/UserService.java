package com.math_dev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.math_dev.workshopmongo.domain.User;
import com.math_dev.workshopmongo.dto.UserDTO;
import com.math_dev.workshopmongo.repositories.UserRepository;
import com.math_dev.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> findAll(){
	    List<User> list = userRepo.findAll();
	    return list;
	}

	public User findById(String id){
	    Optional<User> user = userRepo.findById(id);

	    if(user.isEmpty()) {
	    	System.out.println("NÃO ACHOU!");
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }

	    return user.get();
	}
	
	//Dependendo da situação, para instanciar um User, posso querer acessar o DB;
	//Como UserService já tem acesso, para evitar manutenção posterior o insert foi criado ...
	//No UserService, e não no UserDTO
	public User insert(User obj) {
		return userRepo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
}
