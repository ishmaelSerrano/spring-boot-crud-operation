package com.ishmael.springbootcrudoperation;


import com.ishmael.springbootcrudoperation.model.Books;
import com.ishmael.springbootcrudoperation.repository.BooksRepository;
import com.ishmael.springbootcrudoperation.service.BooksService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringBootCrudOperationApplicationTests {

	private static final int ID = 1;
	private static final String NAME = "NAME";

	@InjectMocks
	private BooksService booksService;

	@Mock
	private BooksRepository booksRepositoryMock;


	@Test
	public void getAllBooks() throws Exception {
		Books books = new Books();
		books.setBookid(982);
		books.setAuthor("E. Balagurusamy");
		books.setBookname("Programming with Java");
		books.setPrice(350);
		List<Books> booksList = Collections.singletonList(books);
		when(booksRepositoryMock.findAll()).thenReturn(booksList);
		//When
		//Then
		assertEquals(books, booksService.getAllBooks().get(0));
	}
/*
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

	@Test
	public void addsNewRide() throws Exception {
		String newRide = "{\"bookid\":\"0982\",\"bookname\":\"Programming with Java\",\"author\":E. Balagurusamy,\"price\":350}";
		mockMvc.perform(MockMvcRequestBuilders.post("/books")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newRide)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
*/

}
