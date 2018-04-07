package com;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.model.Employee;
import com.repository.EmployeeRepository;

@SpringBootApplication
public class ReactiveMain {

	@Bean
	CommandLineRunner employees(EmployeeRepository  employeeRepository) {

		return args -> {
			employeeRepository
					.deleteAll()
			.subscribe(null, null, () -> {

				Stream.of(new Employee(UUID.randomUUID().toString(),
						"Peter", 23000L),new Employee(UUID.randomUUID().toString(),
						"Sam", 13000L),new Employee(UUID.randomUUID().toString(),
						"Ryan", 20000L),new Employee(UUID.randomUUID().toString(),
						"Chris", 53000L)
						)
						.forEach(employee -> {
				employeeRepository
						.save(employee)
						.subscribe(System.out::println);

						});

			})
			;
		};

	}


	public static void main(String[] args) {
		SpringApplication.run(ReactiveMain.class, args);
	}
}