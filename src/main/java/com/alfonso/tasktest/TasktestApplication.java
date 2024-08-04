package com.alfonso.tasktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
		basePackages = {
				"com.alfonso.tasktest.apirest",
				"com.alfonso.tasktest.application",
				"com.alfonso.tasktest.infraestructure"
		})
public class TasktestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasktestApplication.class, args);
	}

}
