import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { RestaurantDashboardComponent } from './restaurant/restaurant-dashboard/restaurant-dashboard.component';
import { RestaurantMenuComponent } from './restaurant-menu/restaurant-menu.component';
import { OrderPageComponent } from './order-page/order-page.component'; // ✅ Import your new component

import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'restaurant-dashboard',
    component: RestaurantDashboardComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'restaurant/:id/menu',
    component: RestaurantMenuComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'order',
    component: OrderPageComponent, // ✅ New route for order placement page
  },
  { path: '**', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
