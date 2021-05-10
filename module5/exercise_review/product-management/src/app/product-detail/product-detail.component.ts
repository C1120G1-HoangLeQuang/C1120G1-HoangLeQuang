import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { Product } from '../module/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('productDetail') productDetails: Product | undefined;
  // tslint:disable-next-line:no-output-rename no-output-on-prefix
  @Output('productEdit') onEdit = new EventEmitter<number>();
  public oldSoLuong: number;

  constructor() { }

  ngOnInit(): void {
  }

  edit(soLuong: string) {
    // tslint:disable-next-line:radix
    this.oldSoLuong = parseInt(soLuong);
    this.onEdit.emit(this.oldSoLuong);
  }
}
