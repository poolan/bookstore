package com.example.bookstorefall2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstorefall2021.model.Book;
import com.example.bookstorefall2021.model.Bookrepository;


@SpringBootApplication
public class Bookstorefall2021Application {
	
	private static final Logger log = LoggerFactory.getLogger(Bookstorefall2021Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstorefall2021Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(Bookrepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Madman", "John", 1957, "0-4944-4261-1", 14.99));
			repository.save(new Book("The Moon", "Peter", 2015, "0-6270-4420-4", 49.99));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
