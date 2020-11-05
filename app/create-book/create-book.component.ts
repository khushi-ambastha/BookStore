import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
//import { iif } from 'rxjs';
import { BookStoreService } from '../book-store.service';
import { Bookdetails } from '../model/Bookdetails';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Bookdetails= new Bookdetails;
 bookForm: FormGroup;
 submitted=false;
  check=false;
 title;
 message;
  constructor(private formBuilder: FormBuilder,private router: Router, private bookservice: BookStoreService) { }

  ngOnInit() {
   
  }

  async addBook(){
    this.submitted=true;
    
    let response= await this.bookservice.addBook(this.book);
    let data= await response;
    if(response.status!=202)
    {
      this.message="Error entering values. Try Again";
    }
    else{
      console.log(response);
      console.log(data);
      this.message="Book Added";
  }
    alert(this.message);
  }
}

