import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, observable } from 'rxjs';
import { Cart } from './cart.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

public cartItemList:any=[];
public productList=new BehaviorSubject([]);
  constructor(private http:HttpClient) { }
 public order:any=[];
 public  gt:number=0;
 
  getProducts(){
    return this.productList.asObservable();

  }
  setProduct(product:any){
    this.cartItemList.push(...product);
    this.productList.next(product);

  }
  addToCart(product:any){
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList);

  }
  getTotalPrice():number{
    let grandTotal:number=0;
    this.cartItemList.map((a:any)=>{
      grandTotal +=(+a.price);
      this.gt+=(+a.price);
    })
    return grandTotal;
  }
  removeCartItems(product:any){
    this.cartItemList.map((a:any,index:any)=>{
      if(product.id===a.id){
        this.cartItemList.splice(index,1);
      }
    })
    this.productList.next(this.cartItemList);

  }
  removeAll(){
    this.cartItemList=[];
    this.productList.next(this.cartItemList);

  }
 

  OrderNow(product:any){
    let grandTotal:number=0;
    this.cartItemList.map((a:any)=>{
      grandTotal +=(+a.price);
      this.gt+=(+a.price);
    })
    var newStr=[];
    var orders=JSON.stringify(product);
     newStr =  JSON.parse(orders)[0];
     var my_json = {"grandTotal": grandTotal,uid:2}

     var data:any = [];
    
         data.push(my_json);
         data.next=newStr;
          //data.push(newStr);
     console.log(data.concate(my_json));
data.concate(my_json)
       // console.log("grandTotal", ":", grandTotal);
    return this.http.post<any>("http://localhost:8180/BuyNow",newStr );


    
  }
  addItemsToCart(cart:Cart){
    let email=sessionStorage.getItem('uid');

    return this.http.post<Cart>("http://localhost:8095/AddToCart",cart);
  }
}
