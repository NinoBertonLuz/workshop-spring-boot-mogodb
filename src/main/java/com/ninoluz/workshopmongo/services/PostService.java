package com.ninoluz.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninoluz.workshopmongo.domain.Post;
import com.ninoluz.workshopmongo.domain.User;
import com.ninoluz.workshopmongo.repository.PostRepository;
import com.ninoluz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}	
}
