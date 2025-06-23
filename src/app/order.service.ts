import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './models/order.model'; // Update this path based on your structure

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private readonly BASE_URL = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) {}

  // POST /orders - Place a new order
  placeOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.BASE_URL}`, order);
  }

  // GET /orders/user/{userId} - Get orders for a specific user
  getOrdersByUser(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.BASE_URL}/user/${userId}`);
  }

  // GET /orders - Admin/Restaurant can get all orders
  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.BASE_URL);
  }

  // PUT /orders/{orderId}/status?status=DELIVERED
  updateOrderStatus(orderId: number, status: string): Observable<Order> {
    return this.http.put<Order>(`${this.BASE_URL}/${orderId}/status`, null, {
      params: { status },
    });
  }

  // DELETE /orders/{orderId} - Admin only
  deleteOrder(orderId: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/${orderId}`);
  }
}
