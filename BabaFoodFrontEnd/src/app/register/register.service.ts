import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
 
  RegisterUser(user: User) {
    return this.http.post<User>("http://localhost:8085/register",user,{responseType:'text' as 'json'});
  }
 
  constructor(private http:HttpClient) { }
}
