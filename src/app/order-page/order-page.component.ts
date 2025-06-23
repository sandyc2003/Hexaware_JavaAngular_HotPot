import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from '../models/menu-item.model';

@Component({
  selector: 'app-order-page',
  templateUrl: './order-page.component.html',
})
export class OrderPageComponent implements OnInit {
  cart: MenuItem[] = [];
  totalPrice: number = 0;
  selectedPayment: string = '';
  orderPlaced: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const cartData = sessionStorage.getItem('cart');
    const priceData = sessionStorage.getItem('totalPrice');

    if (cartData && priceData) {
      this.cart = JSON.parse(cartData);
      this.totalPrice = +priceData;
      console.log('Loaded cart:', this.cart);
      console.log('Loaded totalPrice:', this.totalPrice);
    }
  }

  placeFinalOrder() {
    console.log('Attempting to place order...');
    console.log('Selected payment method:', this.selectedPayment);

    if (!this.selectedPayment) {
      alert('Please select a payment method.');
      return;
    }

    this.orderPlaced = true;

    console.log('Order placed successfully!');
    console.log('Cart contents:', this.cart);
    console.log('Total price:', this.totalPrice);

    // Optional: Clear session storage
    sessionStorage.removeItem('cart');
    sessionStorage.removeItem('totalPrice');
  }

  goToDashboard() {
    console.log('Navigating to dashboard...');
    this.router.navigate(['/dashboard']);
  }
}
