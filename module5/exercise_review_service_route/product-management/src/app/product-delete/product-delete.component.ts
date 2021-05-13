import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../module/product';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.scss']
})
export class ProductDeleteComponent implements OnInit {
  public productDelete: Product;

  constructor(private _activatedRoute: ActivatedRoute,
              private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this.productDelete = this._productService.getProductByIndex(index);
  }

  onDelete() {
    this._productService.deleteById(this.productDelete);
    this._router.navigateByUrl("home");
  }

}
