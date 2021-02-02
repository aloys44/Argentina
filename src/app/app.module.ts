import { NgModule } from '@angular/core';


import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { HeaderComponent } from './components/base/header/header.component';
import { FooterComponent } from './components/base/footer/footer.component';
import { BoardAdminComponent } from './components/base/board-admin/board-admin.component';
import { BoardUserComponent } from './components/base/board-user/board-user.component';
import { EcommerceComponent } from './components/commerce/ecommerce/ecommerce.component';
import { OrdersComponent } from './components/commerce/orders/orders.component';
import { ProductsComponent } from './components/commerce/products/products.component';
import { ShoppingCartComponent } from './components/commerce/shopping-cart/shopping-cart.component';
import { EcommerceService } from './services/commerce/eCommerce/EcommerceService';
import { NoticeComponent } from './components/commerce/notice/notice.component';
import { AddNoticeComponent } from './components/commerce/add-notice/add-notice.component';
import { starRatingComponent } from './components/base/star-rating/star-rating.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './components/user/login/login.component';
import { RegisterComponent } from './components/user/register/register.component';
import { ProfileComponent } from './components/user/profile/profile.component';
import { MapComponent } from './components/openLayer/map/map.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BoardAdminComponent,
    BoardUserComponent,
    EcommerceComponent,
    OrdersComponent,
    ProductsComponent,
    ShoppingCartComponent,
    NoticeComponent,
    AddNoticeComponent,
    starRatingComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
  ],
  providers: [EcommerceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
