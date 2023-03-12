package com.ishmael.springbootcrudoperation.controller;

import com.ishmael.springbootcrudoperation.entity.Books;
import com.ishmael.springbootcrudoperation.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BooksController
{

    @Autowired
    BooksRepository booksRepository;



    @GetMapping("/book")
    public ResponseEntity<List<Books>> getBooks(@RequestParam(required = false) String bookname) {
        try {
            List<Books> books = new ArrayList<Books>();

            if (bookname == null)
                booksRepository.findAll().forEach(books::add);
            else
                booksRepository.findBooksByBooknameContaining(bookname).forEach(books::add);

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books getBooks(@PathVariable long id){
        return booksRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid book id %s", id)));
    }



    @PostMapping("/books")
    public ResponseEntity<Books> createBook(@Valid @RequestBody Books books) {
        try {
            Books _books = booksRepository
                    .save(new Books(books.getBookname(), books.getAuthor(), books.getPrice()));
            return new ResponseEntity<>(_books, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable("id") long id, @RequestBody Books book) {
        Optional<Books> bookData = booksRepository.findById(id);
        if (bookData.isPresent()) {
            Books _book = bookData.get();
            _book.setBookname(book.getBookname());
            _book.setAuthor(book.getAuthor());
            _book.setPrice(book.getPrice());
            return new ResponseEntity<>(booksRepository.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
        try {
            booksRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("inside catch: "+ e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
