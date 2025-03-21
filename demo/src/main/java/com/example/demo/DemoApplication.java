package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final CourseRepository courseRepository;

	public DemoApplication(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add initial courses into the database
		List<Course> courses = List.of(
				new Course(null, "Java Programming", "Learn the basics of Java", "John Doe", 40, 199.99, LocalDateTime.now(), LocalDateTime.now()),
				new Course(null, "Spring Boot", "Spring Boot from scratch", "Jane Smith", 50, 299.99, LocalDateTime.now(), LocalDateTime.now()),
				new Course(null, "Data Structures", "Master DSA with Java", "Alice Johnson", 35, 149.99, LocalDateTime.now(), LocalDateTime.now())
		);

		// Save courses into the database
		courseRepository.saveAll(courses);
		System.out.println("Courses added to the database.");
	}
}

