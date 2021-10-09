import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{map} from 'rxjs/operators';
import { Home } from './home.model';
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http:HttpClient) { }
  public getProducts(home: Home){
    return this.http.get<Home>("http://localhost:8190/getItems");

  }
  public getMenu(home:Home){
    return this.http.get<Home>("http://localhost:8095/getItems");
  }
 addToCart(home:Home){
    return this.http.post<Home>("http://localhost:8095/AddToCart",home);
  } 
  getListProducts(){
    return this.http.get<any>("http://localhost:8190/getItems")
    .pipe(map((res:any)=>{
      return res;
    }))
  }
}
