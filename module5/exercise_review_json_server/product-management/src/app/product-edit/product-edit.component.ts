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
    this._productService.getProductByIndex(index).subscribe(data => {
      this.productEdit = data;
      this.editFormFunction();
    });
  }

  editFormFunction() {
    this.editForm = new FormGroup({
      id: new FormControl(this.productEdit.id),
      nameProduct: new FormControl(this.productEdit.nameProduct, [Validators.required]),
      priceProduct: new FormControl(this.productEdit.priceProduct, [Validators.required]),
      dateRelease: new FormControl(this.productEdit.dateRelease, [Validators.required]),
      nationRelease: new FormControl(this.productEdit.nationRelease, [Validators.required]),
      status: new FormControl(this.productEdit.status, [Validators.required])
    });
  }

  choosePlace(value: string) {
    this.tempXuatXu = value;
  }

  onEdit() {
    console.log(this.editForm.value);
    if(this.editForm.valid) {
      this._productService.update(this.editForm.value, this.productEdit.id).subscribe(data => {
        this._router.navigateByUrl("home");
      }, error => {
        console.log("Error");
      });
    }
  }
}
