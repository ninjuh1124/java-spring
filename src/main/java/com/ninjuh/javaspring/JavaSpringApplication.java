package com.ninjuh.javaspring;

import com.ninjuh.javaspring.repositories.UniversityRepository;
import com.ninjuh.javaspring.resources.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}

	// preloads database with univsersity data
	@Bean
	public CommandLineRunner loadData(UniversityRepository universityRepository) {
		return (args) -> {
			universityRepository.save(new University("UZH", 20000, 720));
			universityRepository.save(new University("ETHZ", 18000, 980));
			universityRepository.save(new University("ZHAW", 9000, 530));
			universityRepository.save(new University("EPFL", 12000, 600));
			universityRepository.save(new University("UNILU", 120, 440));
		};
	}
}
