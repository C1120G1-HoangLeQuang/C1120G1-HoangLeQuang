import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../module/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {
  public productEdit: Product;
  editForm: FormGroup;
  public xuatXu: string[] = ['My', 'TQ', 'VN', 'Anh'];
  public tempXuatXu: string;

  constructor(private _activatedRoute: ActivatedRoute,
              private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this.productEdit = this._productService.getProductByIndex(index);
  }

  editFormFunction() {
    this.editForm = new FormGroup({
      nameProduct: new FormControl('', [Validators.required]),
      priceProduct: new FormControl('', [Validators.required]),
      dateRelease: new FormControl('', [Validators.required]),
      nationRelease: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required])
    });
  }

  choosePlace(value: string) {
    this.tempXuatXu = value;
  }

  onEdit() {
    if(this.editForm.valid) {
      this._productService.update(this.editForm.value);
      this._router.navigateByUrl("/home");
    }
  }

}
