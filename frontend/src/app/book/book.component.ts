import {Component, OnInit} from '@angular/core';
import {BookService} from '../services/book.service'
import { Book } from '../models/book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit{

  book?: Book[];
  currentBook: Book = {};
  currentIndex = -1;
  bookname = '';
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.retrieveBooks();
  }

  retrieveBooks(): void{
    this.bookService.getAll().subscribe({ next:(data) => {
        this.book = data;
        console.log(data);
        this.book = data;
      },
      error: (e) => console.error(e)
    });
  }

  searchByName(): void {
    this.currentBook = {};
    this.currentIndex = -1;

    this.bookService.findByBookName(this.bookname)
      .subscribe({
        next: (data) => {
          this.book = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  setActiveBook(book: Book, index: number): void {
    this.currentBook = book;
    this.currentIndex = index;
  }

}
