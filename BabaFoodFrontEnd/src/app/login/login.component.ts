import { Component, OnInit } from '@angular/core';

import { RestApiService } from '../rest-api.service';
import { User } from '../login/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { DoBootstrap } from '@angular/core';
import "@ng-bootstrap/ng-bootstrap";




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  [x: string]: any;
  user: User = new User();
  email : string;
  pass:string;
  message:any;
  result:{};
  constructor(private service:RestApiService ,private route: ActivatedRoute, private router: Router) {

   }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('type'));

  if(sessionStorage.get){
    if(sessionStorage.getItem('type')==='Admin'){
      console.log("Admin profile");
       this.router.navigate([`/adminProfile`], { queryParams: { redirectTo: this.route.snapshot.url } });
     } if(sessionStorage.getItem('type')==="User"){
      console.log("User profile");
      this.router.navigate([`/home`], { queryParams: { redirectTo: this.route.snapshot.url } });
     }
     
     }

     else{
      this.router.navigate([`/login`]);
      ///alert("Invalid Credencials");
     }
  



  }

  DOLogin(){
    var route = this.router; 
   this.user.email=this.email;
    this.user.pass=this.pass;
    //alert(this.user.email);
    //alert(this.user.pass);
   let res= this.service.login(this.user);
   
  let UserData=this.service.getdata(this.user);
  
  
  UserData.subscribe(result=>{

     
    localStorage.setItem('userdata',JSON.stringify(result));
  
    console.log( result);
    console.log( result.email);
sessionStorage.setItem('uid',result.email);
sessionStorage.setItem('type',result.type);
localStorage.setItem('uid',result.email);
localStorage.setItem('type',result.type);

 // console.log(localStorage.getItem("userdata"));
  console.log(localStorage.getItem("type"));

  })
   res.subscribe(data=>{
   this.message=data;
    console.log(this.message);
     if(this.message=== "Admin"){
      console.log("Admin profile");
       this.router.navigate([`/adminProfile`], { queryParams: { redirectTo: this.route.snapshot.url } });
     }else if(this.message=== "User"){
      console.log("User profile");
      this.router.navigate([`/home`], { queryParams: { redirectTo: this.route.snapshot.url } });
     }
     else{
      this.router.navigate([`/login`]);
      alert("Invalid Credencials");
     }
    
    
    
   }, 
   error => { throw error },
   () => console.log("finished"));
  
   
  }
logout(){
  sessionStorage.clear();
}

}
