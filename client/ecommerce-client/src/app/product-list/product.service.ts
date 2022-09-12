import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API_URL = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) { }

  getOneById(id: number): Observable<Product> {
    return this.http.get<Product>(this.API_URL + id);
  }

  // TODO: create pipe to transform data
  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_URL);
  }

  create(product: Product): Observable<Product> {
    return this.http.post<Product>(this.API_URL, product);
  }

  update(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(this.API_URL + id, product);
  }

  delete(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.API_URL + id);
  }

}
