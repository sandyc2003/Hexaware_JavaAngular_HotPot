import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MenuItem } from './models/menu-item.model';

@Injectable({
  providedIn: 'root',
})
export class MenuService {
  private readonly BASE_URL = 'http://localhost:8080/api/menu';

  constructor(private http: HttpClient) {}

  // GET /api/menu/all
  getAllMenuItems(): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(`${this.BASE_URL}/all`);
  }

  // GET /api/menu/{id}
  getMenuItemById(id: number): Observable<MenuItem> {
    return this.http.get<MenuItem>(`${this.BASE_URL}/${id}`);
  }

  // POST /api/menu/add
  addMenuItem(menuItem: MenuItem): Observable<MenuItem> {
    return this.http.post<MenuItem>(`${this.BASE_URL}/add`, menuItem);
  }

  // PUT /api/menu/update/{id}
  updateMenuItem(id: number, menuItem: MenuItem): Observable<MenuItem> {
    return this.http.put<MenuItem>(`${this.BASE_URL}/update/${id}`, menuItem);
  }

  // DELETE /api/menu/delete/{id}
  deleteMenuItem(id: number): Observable<string> {
    return this.http.delete(`${this.BASE_URL}/delete/${id}`, {
      responseType: 'text',
    });
  }
}
