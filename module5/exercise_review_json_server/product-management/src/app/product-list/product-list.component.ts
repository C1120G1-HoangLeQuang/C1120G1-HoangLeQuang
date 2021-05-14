import { Component, OnInit } from '@angular/core';
import { Product } from '../module/product';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  public product: Product | undefined;
  public newSoLuong: number;
  private _productList: Product[] = [];

  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    // this._productList = this._productService.products;
    this._productService.products.subscribe(data => {
      this._productList = data;
    }, error => {
      console.log(error);
    })
  }

  showDetail(index: number) {
    this._router.navigate(["/detail", index]);
  }

  onEditSL($event: number) {
    this.newSoLuong = $event;
  }


  get productList(): Product[] {
    return this._productList;
  }
}
