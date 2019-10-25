package com.ninjuh.javaspring;

import com.ninjuh.javaspring.repositories.UniversityRepository;
import com.ninjuh.javaspring.repositories.UserRepository;
import com.ninjuh.javaspring.resources.University;
import com.ninjuh.javaspring.resources.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JavaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}

	// preloads database with univsersity data
	@Bean
	public CommandLineRunner loadData(UniversityRepository universityRepository, UserRepository userRepository) {
		return (args) -> {

			University[] universities = new University[] {
					new University("UZH", 20000),
					new University("ETHZ", 18000),
					new University("ZHAW", 9000),
					new University("EPFL", 12000),
					new University("UNILU", 120)
			};

			universityRepository.saveAll(Arrays.asList(universities));

			userRepository.saveAll(Arrays.asList(
					new User("John", universities[1]),
					new User("Amy", universities[0]),
					new User("Phil", universities[0]),
					new User("Inna", universities[4])));
		};
	}

}
