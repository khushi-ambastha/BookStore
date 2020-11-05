import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookStoreService } from '../book-store.service';
import { Review } from '../model/Review';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  check=false;
  reviews: Review[];
  review: Review;
  constructor(private router: Router, private bookservice: BookStoreService) { }

  ngOnInit(){
    this.bookservice.reviewList().subscribe(data => {
      this.reviews=data;
      this.reviews.toString;
    })
  }

  editReview(rev){
    this.check=true;
    this.review= rev;
  
  }
  deleteReview(id: number){
    this.bookservice.deleteReview(id).subscribe(data =>{
      console.log(data);
    });

  }
  update(){
    console.log(this.review);
   this.bookservice.updateReview(this.review).subscribe(data =>{
     console.log(data);
   });
  }
}
