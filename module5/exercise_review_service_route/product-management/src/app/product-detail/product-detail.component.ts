import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import { Product } from '../module/product';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit, OnChanges {
  // tslint:disable-next-line:no-input-rename
  // @Input('productDetail') productDetails: Product | undefined;
  // tslint:disable-next-line:no-output-rename no-output-on-prefix
  @Output('productEdit') onEdit = new EventEmitter<number>();
  public actionOld: string[] = [];
  public product: Product;

  constructor(private _activatedRoute: ActivatedRoute,
              private _productService: ProductService) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this.product = this._productService.getProductByIndex(index); //phuong thuc nay o file service
  }

  edit(productDetails: Product, soLuong: string) {
    // tslint:disable-next-line:radix
    productDetails.status = parseInt(soLuong);
    // @ts-ignore
    this.onEdit.emit(productDetails);

  }

  ngOnChanges(changes: SimpleChanges): void {
    // tslint:disable-next-line:forin
    for (const propName in changes) {
      const change = changes[propName];
      const prevVal = JSON.stringify(change.previousValue);
      this.actionOld.unshift(prevVal);
      console.log(this.actionOld);
    }
  }
}
