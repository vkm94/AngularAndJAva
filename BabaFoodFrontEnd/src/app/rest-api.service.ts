import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


import { User } from './login/user.model';
@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  constructor(private http:HttpClient) { }
  public login( user: User){
  
   return this.http.post<User>("http://localhost:8085/login",user,{responseType:'text' as 'json'});

  }
  public getdata(user: User){
    return this.http.post<User>("http://localhost:8085/GetData",user);
  }
  // public getProduct(product:Product){
  //   return this.http.get<product>("http://localhost:8085/GetData")
  // }

}
