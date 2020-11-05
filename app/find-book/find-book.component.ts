import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookStoreService } from '../book-store.service';
import { Bookdetails } from '../model/Bookdetails';

@Component({
  selector: 'app-find-book',
  templateUrl: './find-book.component.html',
  styleUrls: ['./find-book.component.css']
})
export class FindBookComponent implements OnInit {

  booklist: Bookdetails[];
  bookid;
  bookdetail: Bookdetails= new Bookdetails;
  searchText;
  constructor(private router: Router, private bookservice: BookStoreService) { }

  ngOnInit(){
    this.bookservice.getBookList().subscribe(
      data => { this.booklist=data;
      console.log(data);},
      error=>{console.log(error);
      }
    );
  }

  deleteBook(bookID: number){
    if(
   this.bookservice.deleteBook(bookID).subscribe(data=>{
     console.log(data);

   }))
   {
    if (confirm('Are you Sure You Want To Delete?')) {
      this.booklist.splice(bookID);
      this.router.navigate(['/']);
    }
   }
  
  }
  updateBook(bookdetail){
    this.bookservice.setter(bookdetail);
    this.router.navigate(['updateBook']);
  }
  back(){
     this.router.navigate(['']);
  }
  
  
}
