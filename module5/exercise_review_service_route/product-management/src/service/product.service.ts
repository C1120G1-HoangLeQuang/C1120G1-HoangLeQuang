import { Injectable } from '@angular/core';
import {Product} from '../app/module/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private _products: Product[] | undefined = [
    new Product('dien thoai', 2000, '2021/03/12', 'My', 0),
    new Product('may giat', 1500, '2021/05/21', 'TQ', 4),
    new Product('vi tinh', 3000, '2020/10/23', 'VN', 12),
    new Product('lo nuong', 1000, '2021/04/11', 'My', 7),
    new Product('ban phim', 1200, '2021/12/12', 'Anh', 14),
    new Product('pin dien thoai', 1600, '2021/01/12', 'VN', 0),
  ];

  constructor() { }

  get products(): Product[] | undefined {
    return this._products;
  }

  save(product: Product) {
    this._products.unshift(product);
  }

  getProductByIndex(index: number) {
    return this._products[index];
  }
}
