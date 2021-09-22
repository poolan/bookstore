package com.example.bookstorefall2021.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    
}