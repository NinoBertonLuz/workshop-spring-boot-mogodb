package com.ninoluz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninoluz.workshopmongo.domain.User;
import com.ninoluz.workshopmongo.dto.UserDTO;
import com.ninoluz.workshopmongo.repository.UserRepository;
import com.ninoluz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();		
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto){
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
