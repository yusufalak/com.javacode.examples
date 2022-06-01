package com.javacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.javacourse" })
@SpringBootApplication
public class JavaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCourseApplication.class, args);
	}

}
