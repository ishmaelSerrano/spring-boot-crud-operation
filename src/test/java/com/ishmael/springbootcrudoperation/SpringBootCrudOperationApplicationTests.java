package com.ishmael.springbootcrudoperation;


import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import com.ishmael.springbootcrudoperation.controller.BooksController;
import com.ishmael.springbootcrudoperation.entity.Books;

import com.ishmael.springbootcrudoperation.repository.BooksRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootCrudOperationApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private BooksRepository bookRepository;


	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllBooks() throws Exception {
		Books book1 = new Books(1,"Other People's Clothes", "Kalla Henkel", 200);
		doReturn(Lists.newArrayList(book1)).when(bookRepository).findAll();
		mockMvc.perform(MockMvcRequestBuilders.get("/api/book")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}


	@Test
	public void getSaveBook() throws Exception {
		Books newBook = new Books (1,"Programming with Java.", "E. Balagurusamy", 350);
		Books bookToReturn = new Books(1, "Programming with Java.", "E. Balagurusamy", 350);
		doReturn(bookToReturn).when(bookRepository).save(any());
		mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newBook)))
				.andExpect(status().isCreated());
	}

	@Test
	public void getsSingleBook() throws Exception {
		Books newBook = new Books (1,"Programming with Java.", "E. Balagurusamy", 350);
		doReturn(Optional.of(newBook)).when(bookRepository).findById(1L);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/book/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSingleRide() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/book/4")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}


	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
