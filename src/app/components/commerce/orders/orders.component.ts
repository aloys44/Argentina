import { ProductOrders } from './../../../services/commerce/product/product-orders.model';
import { ProductOrder } from './../../../services/commerce/product/product-order.model';
import { Product } from './../../../services/commerce/product/product.model'
import { AddNoticeComponent} from './../../commerce/add-notice/add-notice.component';

import { EcommerceService } from './../../../services/commerce/eCommerce/EcommerceService';
import { TokenStorageService } from './../../../services/user/connectionService/tokenStorage/token-storage.service';


import {Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";

@Component({
    selector: 'app-orders',
    templateUrl: './orders.component.html',
    styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
    orders: ProductOrders;
    total: number;
    paid: boolean;
    sub: Subscription;
    isLoggedIn = false;
    isLoginFailed = false;
    errorMessage = '';
    roles: string[] = [];
    user:number;



    constructor(private ecommerceService: EcommerceService,
     private tokenStorage: TokenStorageService) {
        this.orders = this.ecommerceService.ProductOrders;
    }

    ngOnInit() {

        if (this.tokenStorage.getToken()) {
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.user = this.tokenStorage.getUser();

           }
        this.paid = false;
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.orders = this.ecommerceService.ProductOrders;

        });
        this.loadTotal();
    }

    pay() {
        this.paid = true;
        this.ecommerceService.saveOrder(this.orders).subscribe();
    }
    

    loadTotal() {
        this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
            this.orders = this.ecommerceService.ProductOrders;
            this.total = this.ecommerceService.Total;
        });
    }
}