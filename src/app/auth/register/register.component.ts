import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  template: `
    <h2>Register</h2>
    <form (ngSubmit)="onSubmit()">
      <input
        type="text"
        [(ngModel)]="name"
        name="name"
        placeholder="Name"
        required
      />
      <input
        type="text"
        [(ngModel)]="userName"
        name="userName"
        placeholder="Username"
        required
      />
      <input
        type="email"
        [(ngModel)]="email"
        name="email"
        placeholder="Email"
        required
      />
      <input
        type="password"
        [(ngModel)]="password"
        name="password"
        placeholder="Password"
        required
      />
      <button type="submit">Register</button>
    </form>
  `,
})
export class RegisterComponent {
  name = '';
  userName = '';
  email = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    this.authService
      .register({
        name: this.name,
        userName: this.userName,
        email: this.email,
        password: this.password,
      })
      .subscribe({
        next: () => this.router.navigate(['/login']),
        error: () => alert('Registration failed'),
      });
  }
}
