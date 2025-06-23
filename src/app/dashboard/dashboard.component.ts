import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../models/restaurant.model';
import { MenuItem } from '../models/menu-item.model';
import { RestaurantService } from '../services/restaurant.service';
import { AuthService } from '../services/auth.service';
import { CartItemDto } from '../models/cart-item.dto';
import { MenuService } from '../menu.service';
import { CartService } from '../cart.service';
import { OrderService } from '../order.service';
import { Order } from '../models/order.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {
  restaurants: Restaurant[] = [];
  menuItems: MenuItem[] = [];
  allMenuItems: MenuItem[] = [];
  userId: number | null = null;

  constructor(
    private restaurantService: RestaurantService,
    private menuService: MenuService,
    private cartService: CartService,
    private orderService: OrderService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.fetchRestaurants();
    this.extractUserIdFromToken();
    this.fetchMenuItems();
  }

  fetchRestaurants(): void {
    this.restaurantService.getAllRestaurants().subscribe({
      next: (res) => (this.restaurants = res),
      error: () => console.error('Failed to fetch restaurants'),
    });
  }

  fetchMenuItems(): void {
    this.menuService.getAllMenuItems().subscribe({
      next: (res: MenuItem[]) => {
        this.allMenuItems = res;
        this.menuItems = res;
      },
      error: () => console.error('Failed to load menu'),
    });
  }

  viewPizzaExpressMenu(): void {
    // Hardcoded menu items for Pizza Express
    this.menuItems = [
      {
        id: 1,
        itemName: 'Pepperoni Pizza',
        category: 'Pizza',
        price: 299,
        availabilityTime: '11:00 AM - 11:00 PM',
        dietaryInfo: 'Non-Veg',
        restaurant: {
          id: 101,
          restaurantName: 'Pizza Express',
          location: 'Mumbai',
          contact: '9876543210',
        },
      },
      {
        id: 2,
        itemName: 'Farmhouse Pizza',
        category: 'Pizza',
        price: 349,
        availabilityTime: '11:00 AM - 11:00 PM',
        dietaryInfo: 'Veg',
        restaurant: {
          id: 101,
          restaurantName: 'Pizza Express',
          location: 'Mumbai',
          contact: '9876543210',
        },
      },
      {
        id: 3,
        itemName: 'Cheese Burst',
        category: 'Pizza',
        price: 279,
        availabilityTime: '11:00 AM - 11:00 PM',
        dietaryInfo: 'Veg',
        restaurant: {
          id: 101,
          restaurantName: 'Pizza Express',
          location: 'Mumbai',
          contact: '9876543210',
        },
      },
    ];
  }

  addToCart(item: MenuItem): void {
    if (!this.userId) return;

    const cartItem: CartItemDto = {
      userId: this.userId,
      menuItemId: item.id!,
      itemName: item.itemName,
      quantity: 1,
      username: '',
      id: 0,
    };

    this.cartService.addToCart(cartItem).subscribe({
      next: () => alert('Item added to cart!'),
      error: () => alert('Failed to add item'),
    });
  }

  placeOrder(): void {
    if (!this.userId) return;

    const order: Order = {
      user: { id: this.userId },
      status: 'PENDING',
      totalPrice: 0,
      orderItems: [], // Enhancement: populate from cart
    };

    this.orderService.placeOrder(order).subscribe({
      next: () => alert('Order placed successfully!'),
      error: () => alert('Failed to place order'),
    });
  }

  private extractUserIdFromToken(): void {
    const token = this.authService.getToken();
    if (token) {
      const payload = JSON.parse(atob(token.split('.')[1]));
      this.userId = payload.id;
    }
  }

  logout(): void {
    this.authService.logout();
  }
}
