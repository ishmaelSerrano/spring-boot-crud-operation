package com.ishmael.springbootcrudoperation;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootCrudOperationApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/book")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}


	@Test
	public void getSaveBook() throws Exception {
		String newBook = "{\"bookname\":\"Programming with Java.\",\"author\":\"E. Balagurusamy\",\"price\":350}";
		mockMvc.perform(MockMvcRequestBuilders.post("/books")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newBook)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getsSingleBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSingleRide() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/book/4")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}




}
