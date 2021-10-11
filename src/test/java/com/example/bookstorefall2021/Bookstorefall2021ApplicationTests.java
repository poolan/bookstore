package com.example.bookstorefall2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstorefall2021.web.BookController;



/**
 * Testing that the context is creating your controller
 * 
 * @author h01270
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Bookstorefall2021ApplicationTests {

    @Autowired
    private BookController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}
