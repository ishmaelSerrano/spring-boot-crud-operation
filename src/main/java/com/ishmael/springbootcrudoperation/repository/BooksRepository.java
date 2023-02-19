package com.ishmael.springbootcrudoperation.repository;

import org.springframework.data.repository.CrudRepository;
import com.ishmael.springbootcrudoperation.model.Books;
//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
