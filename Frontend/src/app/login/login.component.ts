import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { LoginService, LoginResponse } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule]
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const loginData = this.loginForm.value;
      console.log('Submitting login data:', loginData);  // Debugging line to check the payload
      this.loginService.login(loginData).subscribe(
        (response: LoginResponse) => {
          console.log('Login response:', response);  // Debugging line to check the response
          if (response && response.token && response.user) {
            localStorage.setItem('token', response.token);
            localStorage.setItem('id', response.user.id.toString());
            localStorage.setItem('user', JSON.stringify(response.user));
            this.router.navigate(['/dashboard']);
          } else {
            console.error('Login response does not contain user data.');
          }
        },
        (error) => {
          console.error('Login error:', error);
        }
      );
    }
  }
}
