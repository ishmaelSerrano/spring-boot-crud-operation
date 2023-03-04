package com.ishmael.springbootcrudoperation.repository;

import org.springframework.data.repository.CrudRepository;
import com.ishmael.springbootcrudoperation.entity.Books;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Long>
{
    List<Books> findBooksByBooknameContaining(String bookname);

}
