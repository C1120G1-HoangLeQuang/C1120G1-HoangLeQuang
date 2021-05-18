import { Injectable } from '@angular/core';
import {Customer} from '../module/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private _customers: Customer[] = [];
  private API_URL = "http://localhost:3000/customers";

  constructor(private _httpClient: HttpClient) { }

  get customers(): Observable<Customer[]> {
    return this._httpClient.get<Customer[]>(this.API_URL);
  }

  save(customer: Customer): Observable<Customer> {
    return this._httpClient.post<Customer>(this.API_URL, customer);
  }

  getCustomerByIndex(id: number): Observable<Customer> {
    return this._httpClient.get<Customer>(`${this.API_URL}/${id}`);
  }

  update(customer: Customer, id: number): Observable<Customer> {
    return this._httpClient.put<Customer>(`${this.API_URL}/${id}`, customer);
  }

  delete(id: number): Observable<Customer> {
    return this._httpClient.delete<Customer>(`${this.API_URL}/${id}`);
  }

  searchByName(name: string): Observable<Customer[]> {
    return this._httpClient.get<Customer[]>(this.API_URL + "?nameCustomer_like=" + name);
  }

  searchByType(type: string): Observable<Customer[]> {
    return this._httpClient.get<Customer[]>(this.API_URL + "?typeCustomer_like=" + type);
  }
}
