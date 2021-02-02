import { ProductOrders } from './../../../services/commerce/product/product-orders.model';
import { ProductOrder } from './../../../services/commerce/product/product-order.model';

import { EcommerceService } from './../../../services/commerce/eCommerce/EcommerceService';

import { TokenStorageService } from './../../../services/user/connectionService/tokenStorage/token-storage.service';

import { Component, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import { Router } from '@angular/router';
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {
      orderFinished: boolean;
      orders: ProductOrders;
      total: number;
      sub: Subscription;
    private roles: string[];
    isLoggedIn = false;
    showAdminBoard = false;
    showModeratorBoard = false;
    username: string;

    // Output permet de transférer des données du composant enfant vers le parent
    // EventEmitter permet de transférer un évènement au sein de l'Output
    @Output() onOrderFinished: EventEmitter<boolean>;

  constructor(private ecommerceService: EcommerceService, 
  private tokenStorageService: TokenStorageService,
  private router: Router) { 
    this.total = 0;
    this.orderFinished = false;
    this.onOrderFinished = new EventEmitter<boolean>();
  }

  ngOnInit(): void {
    this.orders = new ProductOrders();
      this.loadCart();
      this.loadTotal();

  // si token storage trouve un token alors personne connectée
  this.isLoggedIn = !!this.tokenStorageService.getToken();
  // 
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
        }

  }
      ngOnDestroy() {
        this.sub.unsubscribe();
    }

      loadTotal() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.total = this.calculateTotal(this.orders.productOrders);
        });
    }
        finishOrder() {
          this.orderFinished = true;
          this.ecommerceService.Total = this.total;
          this.onOrderFinished.emit(this.orderFinished);
    }
        private calculateTotal(products: ProductOrder[]): number {
          let sum = 0;
          products.forEach(value => {
              sum += (value.product.price * value.quantity);
          });
          return sum;
    }
      loadCart() {
        // retrouve l'utilisateur connecté si il existe
        const user = this.tokenStorageService.getUser();

        // productOrderChanged est un observable observé par la méthode subscribe
        this.sub = this.ecommerceService.ProductOrderChanged.subscribe(() => {
          // fais appel au constructeur pour avoir SelectedProductOrder 
          // grâce à une instance de productOrder
            let productOrder = this.ecommerceService.SelectedProductOrder;
            // si un produit est selectionné on doit l'intégrer dans la commande
            if (productOrder) {
              // on instancie productOrder qui sera contenu dans orders
                this.orders.productOrders.push(new ProductOrder(
                    productOrder.product, productOrder.quantity, user.id));
            }
            this.ecommerceService.ProductOrders = this.orders;
            this.orders = this.ecommerceService.ProductOrders;
            this.total = this.calculateTotal(this.orders.productOrders);
        });
    }
    goToLoginPage() {
        this.router.navigate(['login']);
        }

    goToLoginUserPage() {
        this.router.navigate(['loginUser']);
        }    

    reset() {
        this.orderFinished = false;
        this.orders = new ProductOrders();
        this.orders.productOrders = []
        this.loadTotal();
        this.total = 0;
    }
  }


