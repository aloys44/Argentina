import { ProductOrders } from './../../../services/commerce/product/product-orders.model';
import { ProductOrder } from './../../../services/commerce/product/product-order.model';
import { Product } from './../../../services/commerce/product/product.model'

import { EcommerceService } from './../../../services/commerce/eCommerce/EcommerceService';
import { UserService } from './../../../services/user/user/user-service';


import { TokenStorageService } from './../../../services/user/connectionService/tokenStorage/token-storage.service';

import {Subscription} from "rxjs/internal/Subscription";
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
   productOrders: ProductOrder[] = [];
    products: Product[] = [];
    selectedProductOrder: ProductOrder;
    private shoppingCartOrders: ProductOrders;
    sub: Subscription;
    productSelected: boolean = false;
    isLoginFailed = false;
    private roles: string[];
    isLoggedIn = false;
    showAdminBoard = false;
    showModeratorBoard = false;
    errorMessage = '';
    username: string;
    isDisplay: boolean = false;

      visible: boolean = true;
  @Output() open: EventEmitter<any> = new EventEmitter();
  @Output() close: EventEmitter<any> = new EventEmitter();


    

    constructor(private ecommerceService: EcommerceService,
        private userService: UserService, 
            private tokenStorageService: TokenStorageService) {
    }

    ngOnInit() {
        this.productOrders = [];
        this.loadProducts();
        this.loadOrders();

                this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
        }

    }

    addToCart(order: ProductOrder) {
        this.ecommerceService.SelectedProductOrder = order;
        this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
        this.productSelected = true;
    }

    removeFromCart(productOrder: ProductOrder) {
        let index = this.getProductIndex(productOrder.product);
        if (index > -1) {
            this.shoppingCartOrders.productOrders.splice(
                this.getProductIndex(productOrder.product), 1);
        }
        this.ecommerceService.ProductOrders = this.shoppingCartOrders;
        this.shoppingCartOrders = this.ecommerceService.ProductOrders;
        this.productSelected = false;
    }

    getProductIndex(product: Product): number {
        return this.ecommerceService.ProductOrders.productOrders.findIndex(
            value => value.product === product);
    }

    isProductSelected(product: Product): boolean {
        return this.getProductIndex(product) > -1;
    }

    loadProducts() {
        // On cherche l'utilisateur connecté
        const user = this.tokenStorageService.getUser();

        // On 
        this.ecommerceService.getAllProducts()
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                    this.products.forEach(product => {
                        this.productOrders.push(new ProductOrder(product, null,null));
                    })
                },
                (error) => console.log(error)
            );
    }

    loadOrders() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.shoppingCartOrders = this.ecommerceService.ProductOrders;
        });
    }
    

    reset() {
        this.productOrders = [];
        this.loadProducts();
        this.ecommerceService.ProductOrders.productOrders = [];
        this.loadOrders();
        this.productSelected = false;
    }
    changeDisplay(){
        console.log(this.isDisplay);
        if(this.isDisplay == false){
        this.isDisplay = true;
        } else {
            this.isDisplay = false;
        }
    }

    
  onOpen($event) {
    console.log('onOpen', $event);
  }

  onClose($event) {
    console.log('onClose', $event);
  }
}