import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book/book.component';
import {BookDetailsComponent} from "./components/book-details/book-details.component";
import {AddBookComponent} from "./components/add-book/add-book.component";


const routes: Routes = [

  { path: 'book', component: BookComponent },
  { path: '', redirectTo: 'book', pathMatch: 'full' },
  { path: 'book', component: BookComponent },
  { path: 'book/:id', component: BookDetailsComponent },
  { path: 'add', component: AddBookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
