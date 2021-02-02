import {Product} from "./product.model";

export class ProductOrder {
    product: Product;
    quantity: number;
    user: number;


    constructor(product: Product, quantity: number,  user:number) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;


    }
}