package com.math_dev.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.math_dev.workshopmongo.domain.Post;
import com.math_dev.workshopmongo.domain.User;
import com.math_dev.workshopmongo.repositories.PostRepository;
import com.math_dev.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User bob = new User(null,"Bob","bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia!","Hoje acordei feliz!",maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, bob, alex));
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
