import { EcommerceComponent } from './components/commerce/ecommerce/ecommerce.component';
import { AddNoticeComponent } from './components/commerce/add-notice/add-notice.component';
import { OrdersComponent } from './components/commerce/orders/orders.component';
import { LoginComponent } from './components/user/login/login.component';
import { RegisterComponent } from './components/user/register/register.component';
import { MapComponent } from './components/openLayer/map/map.component';


import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: EcommerceComponent, pathMatch: 'full' },
  { path: 'home', component: EcommerceComponent },
  { path: 'add-notice', component: AddNoticeComponent },
  { path: 'ecommerce', component: OrdersComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'map', component: MapComponent },




];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
