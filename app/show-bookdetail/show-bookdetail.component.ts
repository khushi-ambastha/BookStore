import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookStoreService } from '../book-store.service';
import { Bookdetails } from '../model/Bookdetails';
import { Review } from '../model/Review';

@Component({
  selector: 'app-show-bookdetail',
  templateUrl: './show-bookdetail.component.html',
  styleUrls: ['./show-bookdetail.component.css']
})
export class ShowBookdetailComponent implements OnInit {

  book: Bookdetails= new Bookdetails;
  review: Review= new Review;
  reviews: Review[];
  avgrating: number;
  bookid;
  check=false;
  constructor(private bookservice: BookStoreService, private router: Router) { }
   
  ngOnInit() 
  {
    console.log("ok");
  
  }
 
  getReview(){
    this.bookservice.reviewByBookId(this.bookid).subscribe(data => {
      this.reviews=data;
      
      console.log(this.reviews);
      var data1 = this.reviews;
      this.avgrating = Object.values(data1).reduce(
        (avg, {
          reviewRating
        }, _, {
          length
        }) => avg + reviewRating / length,
        0
      );
    });
   
  }
 
  async addReview(){
    console.log(this.review);
    
   let response= await this.bookservice.addReview(this.review,this.bookid);
   let data= await response;
   console.log(response);

  }

  find(){
   
    this.bookservice.getBookById(this.bookid).subscribe(data => {
    this.book= data;
    console.log(data);},
    error=>{console.log(error);
    }
  );
  this.check=true;
  this.getReview();
 
  }
  back(){
    this.router.navigate(['findBook']);

  }
}
