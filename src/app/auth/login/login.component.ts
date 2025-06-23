import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  template: `
    <div class="container mt-5" style="max-width: 400px;">
      <h2 class="text-center mb-4">Login</h2>

      <form (ngSubmit)="onSubmit()">
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input
            type="text"
            [(ngModel)]="userName"
            name="userName"
            id="username"
            class="form-control"
            placeholder="Enter username"
            required
          />
        </div>

        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            [(ngModel)]="password"
            name="password"
            id="password"
            class="form-control"
            placeholder="Enter password"
            required
          />
        </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>
      </form>
    </div>
  `,
})
export class LoginComponent {
  userName = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    this.authService
      .login({ userName: this.userName, password: this.password })
      .subscribe({
        next: (res) => {
          this.authService.setToken(res.accessToken);
          const role = res.userDto?.role;
          this.authService.setRole(role);
          localStorage.setItem('loggedInUser', JSON.stringify(res.userDto));

          if (role === 'ROLE_RESTAURANT') {
            this.router.navigate(['/restaurant-dashboard']);
          } else if (role === 'ROLE_CUSTOMER') {
            this.router.navigate(['/dashboard']);
          } else {
            alert('Unknown role: ' + role);
          }
        },
        error: () => alert('Login failed'),
      });
  }
}
