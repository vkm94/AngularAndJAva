import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Menu } from './menu.modal';
import { Hotel } from './hotel.modal';
import { Hotelmenu } from './hotelmenu.modal';
import { User } from '../login/user.model';
@Injectable({
  providedIn: 'root'
})
export class PofileService {
  changePass(user: User) {
    return this.http.post("http://localhost:8085/changePassword",user);
  }
  
 

  constructor(private http:HttpClient) { }

  addItemsToHotel(hotelmenu: Hotelmenu) {
    return this.http.post("http://localhost:8190/addMenuItems",hotelmenu);
  }
  addMenu(menu: Menu) {
    return this.http.post("http://localhost:8095/addMenu",menu);
  }
  getAll() {
    return this.http.get("http://localhost:8280/getOrder");
  }

  addHotel(hotel:Hotel){
    return this.http.post("http://localhost:8090/addHotel",hotel);
  }
  getMenuname(menu: Menu){
    return this.http.get("http://localhost:8095/getItems");
  }
  getHotelname(hotel:Hotel){
    return this.http.get("http://localhost:8090/hotels");
  }
}
