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
  keySearch = '';
  optionSearch = 1;
  keySearch2 = '';
  fromDate: any;
  toDate: any;

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
    this._router.navigate(["/detail", index]); // same same router link
  }

  onEditSL($event: number) {
    this.newSoLuong = $event;
  }


  get productList(): Product[] {
    return this._productList;
  }

  search() {
    // -------------SEARCH BY MANY FIELDS---------------
    // this._productService.searchFields(this.keySearch).subscribe(data => {
    //   this._productList = data;
    // });

    // -------------SEARCH NEAR-CORRECT BY nameProduct OR SOMETHING------------
    if (this.optionSearch == 1) {
      this._productService.searchNearByName(this.keySearch).subscribe(data => {
        this._productList = data;
      });
    } else if (this.optionSearch == 2) {
      this._productService.searchNearByDate(this.keySearch).subscribe(data => {
        this._productList = data;
      });
    } else if (this.optionSearch == 3) {
      this._productService.searchNearByNationAndName(this.keySearch, this.keySearch2).subscribe(data => {
        this._productList = data;
      });
    } else {
      this._productService.searchFromDateToDate(this.fromDate, this.toDate).subscribe(data => {
        this._productList = data;
      })
    }

    // -------------SEARCH EXACTLY BY nameProduct OR SOMETHING------------
    // this._productService.searchExactlyByName(this.keySearch).subscribe(data => {
    //   this._productList = data;
    // })
  }
}
