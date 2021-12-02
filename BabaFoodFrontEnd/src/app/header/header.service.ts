import { Injectable } from '@angular/core';
import { Hotelmenu } from '../admin-profile/hotelmenu.modal';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  search(hotelmenu: Hotelmenu) {
    var name=hotelmenu.mname;
    
   
   return this.http.get("http://localhost:8190/search/"+name)
  }

  constructor(private http:HttpClient) { }
}
