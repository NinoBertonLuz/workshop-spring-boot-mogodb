package com.ninoluz.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ninoluz.workshopmongo.domain.Post;
import com.ninoluz.workshopmongo.domain.User;
import com.ninoluz.workshopmongo.repository.PostRepository;
import com.ninoluz.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private PostRepository postrepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userrepository.deleteAll();
		postrepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("15/11/2022"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("15/11/2022"),"Bom dia", "Acordei feliz hoje!", maria);
		
		userrepository.saveAll(Arrays.asList(maria,alex,bob));
		postrepository.saveAll(Arrays.asList(post1, post2));
		
	}
	

}
