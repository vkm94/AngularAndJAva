import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Hotelmenu } from '../admin-profile/hotelmenu.modal';
import { CartService } from '../cart/cart.service';
import {HeaderService} from './header.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  hotelmenu:Hotelmenu=new Hotelmenu();
public totalItem:number =0;
  constructor(private cartservice: CartService,private headerService:HeaderService) {  }
SearchForm: FormGroup;
  ngOnInit(): void {
    this.SearchForm=new FormGroup({
      search:new FormControl('',[Validators.required])
    })
    this.cartservice.getProducts().subscribe(res=>{
       this.totalItem=res.length;
    })
  }
  search(){
this.hotelmenu.mname=this.SearchForm.value.search;
console.log(this.hotelmenu.mname);
let data=this.headerService.search(this.hotelmenu).subscribe(data=>{
  console.log(data);
})
  }

}
