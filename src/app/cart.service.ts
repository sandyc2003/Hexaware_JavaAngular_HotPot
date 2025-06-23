import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Matches CartItemDto in your backend
export interface CartItemDto {
  id?: number;
  userId: number;
  username?: string; // optional for display
  menuItemId: number;
  itemName?: string; // optional for display
  quantity: number;
}

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private BASE_URL = 'http://localhost:8080/cart';

  constructor(private http: HttpClient) {}

  // POST /cart
  addToCart(cartItem: CartItemDto): Observable<CartItemDto> {
    return this.http.post<CartItemDto>(`${this.BASE_URL}`, cartItem);
  }

  // GET /cart/{userId}
  getCartItems(userId: number): Observable<CartItemDto[]> {
    return this.http.get<CartItemDto[]>(`${this.BASE_URL}/${userId}`);
  }

  // DELETE /cart/{cartItemId}
  removeItem(cartItemId: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/${cartItemId}`);
  }

  // DELETE /cart/clear/{userId}
  clearCart(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/clear/${userId}`);
  }
}
