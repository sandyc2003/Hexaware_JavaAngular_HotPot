import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'; // ✅ Router imported
import { MenuItem } from '../models/menu-item.model';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.component.html',
})
export class RestaurantMenuComponent implements OnInit {
  restaurantId!: number;
  menuItems: MenuItem[] = [];
  userId: number | null = null;

  cart: MenuItem[] = [];
  totalPrice: number = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router, // ✅ Injected router
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.extractUserIdFromToken();
    this.restaurantId = +this.route.snapshot.paramMap.get('id')!;

    // Hardcoded Pizza Express menu
    if (this.restaurantId === 1) {
      this.menuItems = [
        {
          id: 1,
          itemName: 'Pepperoni Pizza',
          category: 'Pizza',
          price: 299,
          availabilityTime: '10:00 AM - 10:00 PM',
          dietaryInfo: 'Non-Veg',
          restaurant: {
            id: 1,
            restaurantName: 'Pizza Express',
            location: 'Downtown',
            contact: '9876543210',
          },
        },
        {
          id: 2,
          itemName: 'Farmhouse Pizza',
          category: 'Pizza',
          price: 349,
          availabilityTime: '10:00 AM - 10:00 PM',
          dietaryInfo: 'Veg',
          restaurant: {
            id: 1,
            restaurantName: 'Pizza Express',
            location: 'Downtown',
            contact: '9876543210',
          },
        },
      ];
    }
  }

  addToCart(item: MenuItem): void {
    this.cart.push(item);
    this.totalPrice += item.price;
  }

  removeFromCart(index: number): void {
    const removedItem = this.cart[index];
    this.totalPrice -= removedItem.price;
    this.cart.splice(index, 1);
  }

  placeOrder(): void {
    if (!this.userId) return;

    // ✅ Save cart and price to sessionStorage
    sessionStorage.setItem('cart', JSON.stringify(this.cart));
    sessionStorage.setItem('totalPrice', this.totalPrice.toString());

    // ✅ Navigate to order page
    this.router.navigate(['/order']);
  }

  logout(): void {
    this.authService.logout();
  }

  private extractUserIdFromToken(): void {
    const token = this.authService.getToken();
    if (token) {
      const payload = JSON.parse(atob(token.split('.')[1]));
      this.userId = payload.id;
    }
  }
}
