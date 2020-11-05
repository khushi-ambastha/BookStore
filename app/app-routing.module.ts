import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateBookComponent } from './create-book/create-book.component';
import { FindBookComponent } from './find-book/find-book.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { ShowBookdetailComponent } from './show-bookdetail/show-bookdetail.component';
//import { FindBookComponent } from './find-book/find-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';


const routes: Routes = [
  {path: 'addBook', component: CreateBookComponent},
  {path: 'updateBook', component: UpdateBookComponent},
  {path: 'findBook', component: FindBookComponent},
  {path: 'showbook', component: ShowBookdetailComponent},
  {path: 'reviewlist', component: ReviewsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
