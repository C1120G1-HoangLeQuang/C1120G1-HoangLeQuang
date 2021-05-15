import { Injectable } from '@angular/core';
import {Product} from '../app/module/product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private _products: Product[] = [];
  public product: Product;
  private API_URL = "http://localhost:3000/products";

  constructor(private _httpClient: HttpClient) { }

  get products(): Observable<Product[]> {
     return this._httpClient.get<Product[]>(this.API_URL);
  }

  save(product: Product): Observable<Product> {  // dung cho create
    return this._httpClient.post<Product>(this.API_URL, product);
  }

  getProductByIndex(id: number): Observable<Product> {  //dung cho detail, edit va delete
    return this._httpClient.get<Product>(`${this.API_URL}/${id}`);
  }

  update(product: Product, id: number): Observable<Product> {  //dung cho edit
    return this._httpClient.put<Product>(`${this.API_URL}/${id}`, product);
  }

  deleteById(id: number): Observable<Product> { //dung cho delete
    return this._httpClient.delete<Product>(`${this.API_URL}/${id}`);
  }

  // -------------SEARCH BY MANY FIELDS---------------
  // searchFields(keySearch: string): Observable<Product[]> {
  //   return this._httpClient.get<Product[]>(this.API_URL + "?q=" + keySearch);
  // }

  // -------------SEARCH NEAR-CORRECT BY nameProduct OR SOMETHING------------
  searchNearByName(keySearch: string): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL + "?nameProduct_like=" + keySearch);
  }
  searchNearByDate(keySearch: string): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL + "?dateRelease_like=" + keySearch);
  }
  searchNearByNationAndName(keySearch: string, keySearch2: string): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL + "?nationRelease_like=" + keySearch + "&nameProduct_like=" + keySearch2);
  }
  searchFromDateToDate(fromDate: any, toDate: any): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL + "?dateRelease=" + fromDate + "&dateRelease=" + toDate);
  }

  // -------------SEARCH EXACTLY BY nameProduct OR SOMETHING------------
  // searchExactlyByName(keySearch: string): Observable<Product[]> {
  //   return this._httpClient.get<Product[]>(this.API_URL + "?nameProduct=" + keySearch);
  // }
}
