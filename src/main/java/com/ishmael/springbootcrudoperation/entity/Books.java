package com.ishmael.springbootcrudoperation.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "books")
public class Books
{

    @Column(name = "bookname")
    private String bookname;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;
    public int getPrice() {
        return price;
    }

    public Books() {

    }

    public Books(String bookname, String author, int price){
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public Books(long id,String bookname, String author, int price){
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    //Defining book id as primary key
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", price=" + price + "]";
    }

}
