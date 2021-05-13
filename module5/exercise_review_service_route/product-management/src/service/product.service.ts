import { Injectable } from '@angular/core';
import {Product} from '../app/module/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private _products: Product[] | undefined = [
    new Product(1, 'dien thoai', 2000, '2021/03/12', 'My', 0),
    new Product(2, 'may giat', 1500, '2021/05/21', 'TQ', 4),
    new Product(3, 'vi tinh', 3000, '2020/10/23', 'VN', 12),
    new Product(4, 'lo nuong', 1000, '2021/04/11', 'My', 7),
    new Product(5, 'ban phim', 1200, '2021/12/12', 'Anh', 14),
    new Product(6,'pin dien thoai', 1600, '2021/01/12', 'VN', 0),
  ];

  constructor() { }

  get products(): Product[] | undefined {
    return this._products;
  }

  save(product: Product) {  // dung cho edit va create
    this._products.unshift(product);
  }

  getProductByIndex(index: number) {  //dung cho detail, edit va delete
    return this._products[index];
  }

  update(product: Product) {
    for (let i = 0; i <= this._products.length; i++) {
      if(this._products[i].id == product.id) {
        this._products[i] = product;
      }
    }
  }
}
