import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrdersService, Order } from '../service/order.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class DashboardComponent implements OnInit {
  orders: Order[] = [];

  constructor(private ordersService: OrdersService) {}

  ngOnInit() {
    this.fetchOrders();
  }

  fetchOrders() {
    this.ordersService.getOrders().subscribe(
      (data: Order[]) => {
        this.orders = data;
      },
      (error) => {
        console.error('Fetch orders error:', error);
      }
    );
  }
}
