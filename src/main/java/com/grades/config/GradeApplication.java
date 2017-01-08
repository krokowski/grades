package com.grades.config;

import com.grades.controller.StudentSubjectController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = {StudentSubjectController.class})
@EnableJpaRepositories(basePackages = "com.grades.dao")
@EntityScan(basePackages = "com.grades.domain")
public class GradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeApplication.class, args);
	}
}
