import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

import { environment } from 'src/environments/environment';

const headers = new HttpHeaders({ 'Content-Type': 'application/json' });


@Injectable({ providedIn: 'root' })
export class CoreService {
  private static service_url = environment.service_url;

  constructor(private http: HttpClient) { }

  getProductsList() {
    return this.http.get(
      `${CoreService.service_url}/seller/products`,
      { headers }
    )
  }

  getProductDetail(productId: number) {
    return this.http.get(
      `${CoreService.service_url}/seller/products/${productId}/bids`,
      { headers }
    )
  }
}