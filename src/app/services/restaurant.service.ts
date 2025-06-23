import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from '../models/restaurant.model';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class RestaurantService {
  private BASE_URL = 'http://localhost:8080/api/restaurants';

  constructor(private http: HttpClient) {}

  // GET /api/restaurants - Get all restaurants
  getAllRestaurants(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(`${this.BASE_URL}`);
  }

  // GET /api/restaurants/{id}
  getRestaurantById(id: number): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${this.BASE_URL}/${id}`);
  }

  // POST /api/restaurants
  addRestaurant(data: Restaurant): Observable<Restaurant> {
    return this.http.post<Restaurant>(`${this.BASE_URL}`, data);
  }

  // PUT /api/restaurants/{id}
  updateRestaurant(id: number, data: Restaurant): Observable<Restaurant> {
    return this.http.put<Restaurant>(`${this.BASE_URL}/${id}`, data);
  }

  // DELETE /api/restaurants/{id}
  deleteRestaurant(id: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/${id}`);
  }
}
