import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Product } from '../module/product';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss']
})
export class ProductCreateComponent implements OnInit {
  // tslint:disable-next-line:no-output-on-prefix no-output-rename
  @Output('productCreate') onCreate = new EventEmitter<Product>();
  public product: Product | undefined;
  public xuatXu: string[] = ['My', 'TQ', 'VN', 'Anh'];
  public tempXuatXu: string;

  constructor() { }

  ngOnInit(): void {
  }

  create(ten: string, gia: string, ngaySX: string, soLuong: string, xuatXu: string) {
    // tslint:disable-next-line:radix
    this.product = new Product(ten, parseInt(gia), ngaySX, xuatXu, parseInt(soLuong));
    this.onCreate.emit(this.product);
  }

  choosePlace(value: string) {
    this.tempXuatXu = value;
  }
}
