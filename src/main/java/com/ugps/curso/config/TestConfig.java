package com.ugps.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ugps.curso.entities.User;
import com.ugps.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; //esse é o objeto que acessa os dados 

	@Override
	public void run(String... args) throws Exception {
	//tudo aqui dentro será iniciado quando o programa rodar
	
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//o userRepository vai receber uma lista e salvar no BD o que for passado como arg.
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
}
