import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Restaurant } from 'src/app/models/restaurant.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service'; // ✅ Import

@Component({
  selector: 'app-restaurant-dashboard',
  templateUrl: './restaurant-dashboard.component.html',
})
export class RestaurantDashboardComponent implements OnInit {
  addForm: FormGroup;
  restaurant: Restaurant | null = null;
  id: number | null = null;
  message = '';

  constructor(
    private fb: FormBuilder,
    private restaurantService: RestaurantService,
    private authService: AuthService, // ✅ Inject AuthService
    private router: Router // ✅ Inject Router
  ) {
    this.addForm = this.fb.group({
      restaurantName: ['', Validators.required],
      location: ['', Validators.required],
      contact: ['', [Validators.required, Validators.pattern(/^\d{8}$/)]],
    });
  }

  ngOnInit(): void {}

  addRestaurant() {
    this.restaurantService.addRestaurant(this.addForm.value).subscribe({
      next: (res: Restaurant) => {
        this.message = 'Restaurant added!';
        this.restaurant = res;
      },
      error: () => (this.message = 'Error adding restaurant'),
    });
  }

  updateRestaurant() {
    if (!this.id) return;
    this.restaurantService
      .updateRestaurant(this.id, this.addForm.value)
      .subscribe({
        next: (res: Restaurant) => {
          this.message = 'Restaurant updated!';
          this.restaurant = res;
        },
        error: () => (this.message = 'Error updating'),
      });
  }

  deleteRestaurant() {
    if (!this.id) return;
    this.restaurantService.deleteRestaurant(this.id).subscribe({
      next: () => {
        this.message = 'Restaurant deleted';
        this.restaurant = null;
      },
      error: () => (this.message = 'Delete failed'),
    });
  }

  viewRestaurantById() {
    if (!this.id) return;
    this.restaurantService.getRestaurantById(this.id).subscribe({
      next: (res: Restaurant) => {
        this.restaurant = res;
        this.addForm.patchValue({
          restaurantName: res.restaurantName,
          location: res.location,
          contact: res.contact,
        });
        this.message = '';
      },
      error: () => (this.message = 'Not found'),
    });
  }

  // ✅ LOGOUT method
  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
