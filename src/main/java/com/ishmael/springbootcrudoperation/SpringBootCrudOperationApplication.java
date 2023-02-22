package com.ishmael.springbootcrudoperation;

import com.ishmael.springbootcrudoperation.entity.Books;
import com.ishmael.springbootcrudoperation.repository.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}


}
