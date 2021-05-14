import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Product } from '../module/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss']
})
export class ProductCreateComponent implements OnInit {
  // tslint:disable-next-line:no-output-on-prefix no-output-rename
  // @Output('productCreate') onCreate = new EventEmitter<Product>();
  public product: Product | undefined;
  public xuatXu: string[] = ['My', 'TQ', 'VN', 'Anh'];
  public tempXuatXu: string;
  createForm: FormGroup;

  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    this.createFormFunction();
  }
  createFormFunction() {
    this.createForm = new FormGroup({
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

  onSubmit() {
    if (this.createForm.valid) {
      this._productService.save(this.createForm.value).subscribe(data => {
        this._router.navigateByUrl("/home"); //khi create thanh cong se chuyen huong sang trang home
      }, error => {
        console.log("Error");
      });
    }
  }
}
