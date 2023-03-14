import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

const baseUrl = "http://localhost:8080/api/book";
const baseUrlsave = "http://localhost:8080/api/books";

@Injectable({
  providedIn: 'root'
})
export class BookService {
 id: any;


  constructor(private http: HttpClient) { }

  getAll(): Observable<Book[]>{
    return this.http.get<Book[]>(baseUrl);
  }

  get(id: any): Observable<Book> {
    return this.http.get<Book>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrlsave, data);
  }

  findByBookName(bookname: any): Observable<Book[]> {
    return this.http.get<Book[]>(`${baseUrl}?bookname=${bookname}`);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrlsave}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrlsave}/${id}`);
  }

}
