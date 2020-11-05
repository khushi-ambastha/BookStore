import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BookStoreService } from '../book-store.service';
import { Bookdetails } from '../model/Bookdetails';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  book: Bookdetails=new Bookdetails;
  bookForm: FormGroup;
  submitted=false;
   check=false;
   title;
  constructor(private router: Router, private bookservice: BookStoreService) { }

  ngOnInit() {
    this.book=this.bookservice.getter();
    console.log(this.book);
  }

  async updateBook(){
    let response = await this.bookservice.updateBook(this.book);
    let data= await response;
    console.log(response);
    if(response.status!=202)
    {
      alert("Enter values properly. Book not updated!");
    }
    else
    {
      alert("Book updated");
    }
  }
}
