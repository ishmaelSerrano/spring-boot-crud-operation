package com.ishmael.springbootcrudoperation.controller;

import com.ishmael.springbootcrudoperation.entity.Books;
import com.ishmael.springbootcrudoperation.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BooksController
{

    private final BooksRepository booksRepository;
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Books> getBooks() {
        return booksRepository.findAll();
    }
    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books getBooks(@PathVariable long id){
        return booksRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid book id %s", id)));
    }


    @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Books createBook(@Valid @RequestBody Books books) {
        return booksRepository.save(books);
    }

}
