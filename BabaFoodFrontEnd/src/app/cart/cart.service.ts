import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, observable } from 'rxjs';
import { Cart } from './cart.model';
import { ProductOrders } from './product-orders.model';
import { ProductOrder } from './product-order.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList: any = [];
  public productList = new BehaviorSubject([]);

  constructor(private http: HttpClient) { }
  public order: any = [];
  public gt: number = 0;

  getProducts() {
    return this.productList.asObservable();

  }
  setProduct(product: any) {
    this.cartItemList.push(...product);
    this.productList.next(product);

  }
  addToCart(product: any) {
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList);

  }
  getTotalPrice(): number {
    let grandTotal: number = 0;
    this.cartItemList.map((a: any) => {
      grandTotal += (+a.price);
      this.gt += (+a.price);
    })
    return grandTotal;
  }
  removeCartItems(product: any) {
    this.cartItemList.map((a: any, index: any) => {
      if (product.id === a.id) {
        this.cartItemList.splice(index, 1);
      }
    })
    this.productList.next(this.cartItemList);

  }
  removeAll() {
    this.cartItemList = [];
    this.productList.next(this.cartItemList);

  }


  OrderNow(product: any) {
    let grandTotal: number = 0;
    this.cartItemList.map((a: any) => {
      grandTotal += (+a.price);
      this.gt += (+a.price);
    })
    var newStr = [];
    var date = new Date().toJSON("yyyy/MM/dd HH:mm");

    var orders = JSON.stringify(product);
    newStr = JSON.parse(orders)[0];
    let email = sessionStorage.getItem('uid');
    var my_json = { "grandTotal": grandTotal };
    var user = { "email": email };
    //const combinedB = my_json.(user);
    var data: any = [];
    var element: any = {}, cart1: any = [];
    element.uid = email;
    element.payment_id = Math.random() * 327;
    element.grandtotal = grandTotal;
    element.hid = newStr.hid;
    element.hname = newStr.hname;
    element.pid = newStr.pid;
    element.pname = newStr.pname;
    element.order_time = date;
    cart1.push(element);

    console.log(JSON.stringify(cart1));

    return this.http.post<any>("http://localhost:8180/BuyNow", cart1[0]);




  }
  addItemsToCart(cart: Cart) {
    let email = sessionStorage.getItem('uid');
    //sessionStorage.getItem('uid');
    //cart.push(email);
    //alert(cart);
    return this.http.post<Cart>("http://localhost:8095/AddToCart", cart);
  }
}
