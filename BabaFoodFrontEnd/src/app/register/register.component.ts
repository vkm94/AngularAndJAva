import { Component, OnInit } from '@angular/core';
import { RestApiService } from '../rest-api.service';
import { User } from './user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import{RegisterService} from'./register.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { isInteger } from '@ng-bootstrap/ng-bootstrap/util/util';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  isAdded = false;
  type = 'User';  
  status='Active';
  
  

  constructor(private service:RestApiService ,private registerService:RegisterService,private route: ActivatedRoute, private router: Router) { }
  registerForm: FormGroup;   
  
  ngOnInit(): void {
   this.registerForm=new FormGroup({
    name:new FormControl('',[Validators.required, Validators.minLength(5)]),

    email:new FormControl('',[Validators.required, Validators.minLength(5)]),
    pass:new FormControl('',[Validators.required, Validators.minLength(5)]),
    cpass:new FormControl('',[Validators.required, Validators.minLength(5)]),
    phno : new FormControl('',[Validators.required,Validators.pattern("^[0-9]*$"), Validators.minLength(10)]),
    type: new FormControl(this.type),
    status: new FormControl(this.status),


   });
  }
  onSubmit(){
    this.user.name=this.registerForm.value.name;
    this.user.email=this.registerForm.value.email;
    this.user.pass=this.registerForm.value.pass;
    this.user.cpass=this.registerForm.value.cpass;
    this.user.phno=this.registerForm.value.phno;
    this.user.type=this.registerForm.value.type;
    
    this.user.status=this.registerForm.value.status;
    console.log(this);
    if(this.user.pass ===this.user.cpass){
      this.save();
    }
   alert("Password Missmatch");
  }
  save(){
    this.registerService.RegisterUser(this.user).subscribe(user=>{
      console.log(user)
    alert(user)});
  }
  reset(){

  }
}

