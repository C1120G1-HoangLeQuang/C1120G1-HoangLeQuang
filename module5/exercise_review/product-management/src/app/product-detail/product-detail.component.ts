import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import { Product } from '../module/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit, OnChanges {
  // tslint:disable-next-line:no-input-rename
  @Input('productDetail') productDetails: Product | undefined;
  // tslint:disable-next-line:no-output-rename no-output-on-prefix
  @Output('productEdit') onEdit = new EventEmitter<number>();
  public actionOld: Product;

  constructor() { }

  ngOnInit(): void {
  }

  edit(productDetails: Product, soLuong: string) {
    // tslint:disable-next-line:radix
    productDetails.status = parseInt(soLuong);
    // @ts-ignore
    this.onEdit.emit(productDetails);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    this.actionOld = changes.productDetails.previousValue;
  }
}
