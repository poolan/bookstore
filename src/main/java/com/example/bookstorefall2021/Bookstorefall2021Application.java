package com.example.bookstorefall2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstorefall2021.model.Book;
import com.example.bookstorefall2021.model.Bookrepository;
import com.example.bookstorefall2021.model.Category;
import com.example.bookstorefall2021.model.CategoryRepository;



@SpringBootApplication
public class Bookstorefall2021Application {
	
	private static final Logger log = LoggerFactory.getLogger(Bookstorefall2021Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstorefall2021Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(Bookrepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Romance"));
			
			repository.save(new Book("Madman", "John", 1957, "0-4944-4261-1", 14.99, crepository.findByName("Romance").get(0)));
			repository.save(new Book("The Moon", "Peter", 2015, "0-6270-4420-4", 49.99, crepository.findByName("Horror").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
