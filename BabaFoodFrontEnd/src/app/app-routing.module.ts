import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';

const routes: Routes = [
  { path:"",redirectTo:"login" ,pathMatch:"full" },
  { path:"login",component:LoginComponent },
  { path:"home",component:HomeComponent},
  { path:"adminProfile",component:AdminProfileComponent},
  { path:"register",component:RegisterComponent},
  {path:"cart",component:CartComponent},
  {path:"header",component:HeaderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
