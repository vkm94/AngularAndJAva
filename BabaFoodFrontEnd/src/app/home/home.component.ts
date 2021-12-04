import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HomeService } from './home.service';
import { Home } from './home.model';
import { Menu } from './menu.modal';
import { Key } from 'selenium-webdriver';
import { CartService } from '../cart/cart.service';
import { HeaderService } from '../header/header.service';
import {PofileService} from '../admin-profile/pofile.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
home:Home=new Home();
//profile:PofileService=new PofileService();
data2:any=[];

result:any;
  data1: any;
  constructor(private service:HomeService,private route: ActivatedRoute, private router: Router,private cartservice:CartService,private headerservice:HeaderService) { 
    // getData(){
    //   this.data2=this.headerservice.search();
    // }
  }

  ngOnInit() {
    let result=this.service.getProducts(this.home);
       result.subscribe(data=>{
         this.result=data;
      //return result;
       console.log(data);
           this.result.forEach((a:any) => {
           Object.assign(a,{quantity:1,total:a.price});
           });
        })

    let data1=this.service.getMenu(this.home);
      data1.subscribe(data=>{
      console.log("added");
      this.data1=data;
      var m=localStorage.getItem('userdata');
        console.log(localStorage.getItem('userdata'));

 
    })
   
  }
  
  //var data1=;
  addToCart(result:any){
   this.cartservice.addToCart(result);
    alert("added");
  }

}
