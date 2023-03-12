import { Component, Input, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/models/book';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentBook: Book = {
    bookname: '',
    author: '',
    price: 0
  };

  message = '';

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getBook(this.route.snapshot.params["id"]);
    }
  }

  getBook(id: string): void {
    this.bookService.get(id)
      .subscribe({
        next: (data) => {
          this.currentBook = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updatePrice(price: number): void {
    const data = {
      bookname: this.currentBook.bookname,
      author: this.currentBook.author,
      price: this.currentBook.price
    };

    this.message = '';

    this.bookService.update(this.currentBook.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentBook.price = 0;
          this.message = res.message ? res.message : 'The price was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  updateBook(): void {
    this.message = '';

    this.bookService.update(this.currentBook.id, this.currentBook)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This book was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteBook(): void {
    this.bookService.delete(this.currentBook.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/book']);
        },
        error: (e) => console.error(e)
      });
  }

}
