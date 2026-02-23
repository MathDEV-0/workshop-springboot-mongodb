package com.math_dev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.math_dev.workshopmongo.domain.Post;
import com.math_dev.workshopmongo.repositories.PostRepository;
import com.math_dev.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepo;
	
	
	public Post findById(String id){
	    Optional<Post> post = postRepo.findById(id);

	    if(post.isEmpty()) {
	    	System.out.println("NÃO ACHOU!");
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }

	    return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return postRepo.findByTitleContainingIgnoreCase(text);
	}
	
	
}
