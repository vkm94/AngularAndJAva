import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  status: boolean = false;
 
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }
  clickEvent(){
    this.status = !this.status;       
}
logout(){
  sessionStorage.clear();
  this.router.navigate([`/login`]);
}
}
