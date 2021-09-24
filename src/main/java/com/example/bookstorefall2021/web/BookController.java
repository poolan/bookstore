package com.example.bookstorefall2021.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstorefall2021.model.Book;
import com.example.bookstorefall2021.model.Bookrepository;
import com.example.bookstorefall2021.model.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	private Bookrepository repository;
	
	@Autowired
	private CategoryRepository crepository; 

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String showIndex() {
		return "index";
	}
	
	 @RequestMapping(value={ "/", "/booklist"})
	    public String bookList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "booklist";
	    }
	 
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("books", new Book());
	    	model.addAttribute("categories", crepository.findAll());
	        return "addbook";
	    } 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Book book) {
			repository.save(book);
			return "redirect:booklist";
		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long studentId, Model model) {
			repository.deleteById(studentId);
			return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editBook(@PathVariable("id") Long bookId, Model model) {
			
			Optional<Book> book = repository.findById(bookId);
			model.addAttribute("books", repository.findById(bookId));	
			model.addAttribute("categories", crepository.findAll());
			return "modifybook";
		}
	 

}
