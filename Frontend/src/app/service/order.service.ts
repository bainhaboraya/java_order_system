import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export interface Order {
  id: number;
  username: string;
  date: string;
  total_price: number;
  status: string;
}

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  private apiUrl = 'http://127.0.0.1:8080/api/orders';

  constructor(private http: HttpClient) {}

  getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.apiUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    console.error('OrdersService error:', error);
    return throwError(error);
  }
}
