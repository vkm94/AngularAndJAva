import { Component, OnInit } from '@angular/core';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
public product:any =[];
public grandTotal !:number;
  constructor(private carservice:CartService) { }

  ngOnInit(): void {
    this.carservice.getProducts().subscribe(res=>{
      this.product=res;
      this.grandTotal=this.carservice.getTotalPrice();
    })
  }
  removeItem(item:any){
    this.carservice.removeCartItems(item);

  }
  EmptyCart(){
    this.carservice.removeAll();
  }
  PayNow(product:any){
    this.product.grandTotal=this.grandTotal;
    this.carservice.OrderNow(product).subscribe(data=>{
      console.log(data);
    });
   
  }
}
