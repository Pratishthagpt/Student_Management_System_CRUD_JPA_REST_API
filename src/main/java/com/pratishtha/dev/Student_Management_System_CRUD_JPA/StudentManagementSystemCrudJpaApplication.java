package com.pratishtha.dev.Student_Management_System_CRUD_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentManagementSystemCrudJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemCrudJpaApplication.class, args);
	}

}
