import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

export interface LoginResponse {
  token: string;
  user: {
    id: number;
    name: string;
    email: string;
  };
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://127.0.0.1:8080/api/auth/login';

  constructor(private http: HttpClient) { }

  login(data: { email: string; password: string }): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl, data).pipe(
      map(response => {
        if (response && response.token && response.user) {
          return response;
        } else {
          throw new Error('Invalid login response');
        }
      }),
      catchError(error => {
        console.error('LoginService error:', error);
        return throwError(() => new Error('Error during login attempt.'));
      })
    );
  }
}
