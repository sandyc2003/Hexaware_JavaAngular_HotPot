import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Components
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';

// Interceptors & Guards
import { AuthInterceptor } from './interceptors/jwt.interceptor';
import { AuthGuard } from './guards/auth.guard';

// Services
import { AuthService } from './services/auth.service';
import { RestaurantDashboardComponent } from './restaurant/restaurant-dashboard/restaurant-dashboard.component';
import { AddRestaurantComponent } from './restaurant/add-restaurant/add-restaurant.component';
import { MenuListComponent } from './restaurant/menu-list/menu-list.component';
import { UpdateMenuItemComponent } from './restaurant/update-menu-item/update-menu-item.component';
import { RestaurantMenuComponent } from './restaurant-menu/restaurant-menu.component';
import { OrderPageComponent } from './order-page/order-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    RestaurantDashboardComponent,
    AddRestaurantComponent,
    MenuListComponent,
    UpdateMenuItemComponent,
    RestaurantMenuComponent,
    OrderPageComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [
    AuthService,
    AuthGuard, // ✅ Needed for route protection
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
