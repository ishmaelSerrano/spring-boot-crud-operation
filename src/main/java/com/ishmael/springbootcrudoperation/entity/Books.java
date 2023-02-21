package com.ishmael.springbootcrudoperation.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter
@ToString
@NoArgsConstructor
public class Books
{
    //Defining book id as primary key
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String bookname;
    @NotEmpty
    private String author;
    private int price;

    public Books(String name, String bookname, String author, int price){
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

}
