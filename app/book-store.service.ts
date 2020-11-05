import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Bookdetails } from './model/Bookdetails';
import { Review } from './model/Review';
@Injectable({
  providedIn: 'root'
})

export class BookStoreService {

  private bookdetail: Bookdetails= new Bookdetails;
  
  constructor(private http: HttpClient) { }
  private baseUrl ="http://localhost:8080/BookStore/admin";

  setter(book: Bookdetails){
    this.bookdetail=book;
  }
  getter(){
    return this.bookdetail;
  }
  public addBook(book: any){
    let options = {
      method: "POST",
      body: JSON.stringify( book),
      headers: { "Content-Type": "application/json" }
    };
    return fetch(this.baseUrl+"/addBook",options);
  }

  public updateBook(book: any){
    let options = {
      method: "POST",
      body: JSON.stringify( book),
      headers: { "Content-Type": "application/json" }
    };
    return fetch(this.baseUrl+"/updateBook",options);
  }

  public getBookList():Observable<any>{
    return this.http.get(this.baseUrl+"/getBookList");
  }

  public getBookById(id):Observable<any>{
    return this.http.get(this.baseUrl+"/getBookByID/"+id);
  }

  public deleteBook(id){
    return this.http.delete(this.baseUrl+"/deleteBook/"+id);
  }

  public addReview(review: Review,id:any){
    console.log(review);
    let options = {
      method: "POST",
      body: JSON.stringify( review),
      headers: { "Content-Type": "application/json" }
    };
    return fetch(this.baseUrl+"/addReview/"+id, options);
  }

  public reviewList():Observable<any>{
    return this.http.get(this.baseUrl+"/getAllReviews");
  }

  public reviewByBookId(id):Observable<any>{
    return this.http.get(this.baseUrl+"/getReviewsByBookId/"+id);
  }
 
  public updateReview(review:Review){
    return this.http.post(this.baseUrl+"/updateReview",review);
  }
  public deleteReview(id){
    return this.http.delete(this.baseUrl+"/deleteReview/"+id);
  }

}
