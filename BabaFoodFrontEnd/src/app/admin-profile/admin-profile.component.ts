import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Hotel } from './hotel.modal';
import { Hotelmenu } from './hotelmenu.modal';
import { Menu } from './menu.modal';
import { PofileService } from './pofile.service';
import { User } from '../login/user.model';


@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AdminProfileComponent implements OnInit {
  menu: Menu=new Menu();
  user : User=new User();
  hotel:Hotel=new Hotel();
  hotelmenu:Hotelmenu =new Hotelmenu();
  status: boolean = false;
   hotelname1:any='';
   menuName:any='';
   

   selectHotelName(event:any){
     this.hotelname1=event.target.value;
    

   }
   selectMenuName(event:any){
    this.menuName=event.target.value;
   }

  constructor(private route: ActivatedRoute, private router: Router,config: NgbModalConfig, private modalService: NgbModal,private profileService:PofileService)
   {
    config.backdrop = 'static';
    config.keyboard = false;
   }
   result1:any;
   hotelname:any;
   AddMenu: FormGroup;
   hotelForm:FormGroup;
   additemToHotel:FormGroup;
   passwordForm:FormGroup;
   //addMenuToHotel:FormGroup;
  ngOnInit(): void {
  
    this.AddMenu=new FormGroup({

      name:new FormControl('',[Validators.required, Validators.minLength(5)]),
  
      descr:new FormControl('',[Validators.required, Validators.minLength(5)]),
      img :new FormControl('',[Validators.required, Validators.minLength(5)]),
     
    });
    this.hotelForm=new FormGroup({
      
      name:new FormControl('',[Validators.required, Validators.minLength(5)]),
  
      descr:new FormControl('',[Validators.required, Validators.minLength(5)]),
      addr:new FormControl('',[Validators.required, Validators.minLength(5)]),
      img :new FormControl('',[Validators.required, Validators.minLength(5)]),
      
      cno:new FormControl('',[Validators.required, Validators.minLength(5)]),
      supply:new FormControl('',[Validators.required, Validators.minLength(5)]),
      service:new FormControl('',[Validators.required, Validators.minLength(5)]),
      class :new FormControl('',[Validators.required, Validators.minLength(5)]),
    });
    this.additemToHotel=new FormGroup({
hname:new FormControl('',[Validators.required]),
menu:new FormControl('',[Validators.required]),
price:new FormControl('',[Validators.required]),
img:new FormControl('',[Validators.required])
    });


    this.passwordForm=new FormGroup({
      password:new FormControl('',[Validators.required]),
      cpassword:new FormControl('',[Validators.required]),
    });
    let menu1:any;
    let hotel:any;

  let data1: any;

    menu1=  this.profileService.getMenuname(this.menu).subscribe((data: any)=>{
        
        this.result1=data;
       
      });
     
     
   hotel= this.profileService.getHotelname(this.hotel).subscribe((data: any)=>{
        this.hotelname=data; console.log(data);
       });
    // alert(this.hotelname1);
    
  }
  clickEvent(){
    this.status = !this.status;       
}
  
result:any;
open(content:any){
    this.profileService.getAll().subscribe(data=>{
   // console.log(data);
    this.result=data;
   // const modalRef = this.modalService.open(ModelComponent, { modalDialogClass: 'modal-lg', backdrop: 'static' });

  })
  
  this.modalService.open(content,{ size: 'xl' });
}

AdddHotel(content:any){
  this.modalService.open(content, { size: 'md' });
}

addMenu(content:any){
  this.modalService.open(content, { size: 'md' });
}
ChangePassword(content:any){
  this.modalService.open(content, { size: 'md' });
}
ViewItems(content:any){
  this.modalService.open(content, { size: 'md' });
}


AddItems(content:any){
  this.modalService.open(content, { size: 'md' });
}

openXl(content:any) {
  this.modalService.open(content, { size: 'xl' });
}
openNew(content:any) {
  this.modalService.open(content, { size: 'sm' });
}
addHotels(){
  this.hotel.name=this.hotelForm.value.name;
  this.hotel.cno=this.hotelForm.value.cno;
  this.hotel.descr=this.hotelForm.value.descr;
  this.hotel.img=this.hotelForm.value.img;
  this.hotel.class=this.hotelForm.value.class;
  this.hotel.service=this.hotelForm.value.service;
  this.hotel.supply=this.hotelForm.value.supply;
  console.log(this);
  this.profileService.addHotel(this.hotel).subscribe(hotel=>{
    console.log(hotel);
    
  })

}

addMenuToHotel(){
this.hotelmenu.hname=this.additemToHotel.value.hname;
this.hotelmenu.mname=this.additemToHotel.value.menu;
this.hotelmenu.price=this.additemToHotel.value.price;
this.hotelmenu.img=this.additemToHotel.value.img;
console.log(this.hotelmenu);
this.profileService.addItemsToHotel(this.hotelmenu).subscribe(hotelmenu=>{
console.log(this.hotelmenu);

})
}

changePassword(){
alert(sessionStorage.getItem('uid'))
  var email=sessionStorage.getItem('uid');

 
if(email){
  this.user.email= email;

  this.user.pass=this.passwordForm.value.password;
  alert( this.user.pass);
  var cpass=this.passwordForm.value.cpassword;
  
  if(this.user.pass===  cpass){
    this.profileService.changePass(this.user).subscribe(user=>{
      console.log(this.user);
      
      })
    }
  }
}
addMenuItems(){
  
  this.menu.name=this.AddMenu.value.name;
  this.menu.img=this.AddMenu.value.img;
  this.menu.descr=this.AddMenu.value.descr;
  console.log(this);
 // this.AddMenu=new FormGroup({})
 // alert("etret");
 this.profileService.addMenu(this.menu).subscribe(menu=>{
   console.log(this.menu);
   

 })
console.log(this.menu);
}
logout(){
  sessionStorage.clear();
  this.router.navigate([`/login`]);
}
}
function ModelComponent(ModelComponent: any, arg1: { class: string; backdrop: "static"; }) {
  throw new Error('Function not implemented.');
}




