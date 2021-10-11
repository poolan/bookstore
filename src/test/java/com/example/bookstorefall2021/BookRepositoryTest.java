package com.example.bookstorefall2021;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstorefall2021.model.Book;
import com.example.bookstorefall2021.model.Bookrepository;
import com.example.bookstorefall2021.model.Category;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private Bookrepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Madman");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("John");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Chess", "Capablanca", 1950, "0-8493-7064-7", 34.99, new Category("Drama"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	 @Test
		public void deleteNewBook() {
			List<Book> books = repository.findByTitle("Madman");
			Book book = books.get(0);
			repository.delete(book);
			List<Book> newBooks = repository.findByTitle("Madman");
			
			assertThat(newBooks).hasSize(0);
		}

	
	

}