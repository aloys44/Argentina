
import { TokenStorageService } from './../../../services/user/connectionService/tokenStorage/token-storage.service';
import { Component, OnInit, ViewChild } from '@angular/core';

import { OrdersComponent } from './../../commerce/orders/orders.component';
import { ProductsComponent } from './../../commerce/products/products.component';
import { ShoppingCartComponent } from './../../commerce/shopping-cart/shopping-cart.component';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
     public collapsed = true;
      orderFinished = false;
      private roles: string[];
      isLoggedIn = false;
      isAdmin = false;
      isUser = false;
      ROLE_USER = "ROLE_USER";


      showAdminBoard = false;
      showModeratorBoard = false;
      username: string;

      @ViewChild('productsC')
      productsC: ProductsComponent;

      @ViewChild('shoppingCartC')
      shoppingCartC: ShoppingCartComponent;

      @ViewChild('ordersC')
      ordersC: OrdersComponent;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
        this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      console.log(this.roles)
          if(this.roles.includes('ROLE_USER')){
        this.isUser = true;
        console.log(this.isUser)

      } else{
        this.isAdmin = true;
        console.log(this.isAdmin)

      }

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }
  }
        logout(): void {
      this.tokenStorageService.signOut();
      window.location.reload();
  }

        reset() {
        this.orderFinished = false;
        this.productsC.reset();
        this.shoppingCartC.reset();
        this.ordersC.paid = false;
    }

        toggleCollapsed(): void {
        this.collapsed = !this.collapsed;
    }

}
