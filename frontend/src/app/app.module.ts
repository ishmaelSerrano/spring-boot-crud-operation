import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from  '@angular/common/http';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { AppRoutingModule } from './app-routine.module';
import { FormsModule } from '@angular/forms';
import {BookDetailsComponent} from "./components/book-details/book-details.component";


@NgModule({
  declarations: [
    AppComponent,
    AddBookComponent,
    BookComponent,
    BookDetailsComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
