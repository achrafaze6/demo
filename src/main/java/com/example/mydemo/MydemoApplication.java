package com.example.mydemo;

import com.example.mydemo.user.MyUser;
import com.example.mydemo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository)
	{

		return args -> {
			userRepository.save(MyUser.builder().email("email@gmail.com").username("dsfbnd").password("kdjfskj").build());
		};
	}

}
