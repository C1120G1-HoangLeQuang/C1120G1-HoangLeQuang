import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  public typeCustomers: string[] = ["Diamond", "Gold", "Silver"];
  public tempType: string;
  createForm: FormGroup;

  constructor(private _customerService: CustomerService,
              private _router: Router) { }

  ngOnInit(): void {
    this.createCustomerFunction();
  }

  createCustomerFunction() {
    this.createForm = new FormGroup({
      nameCustomer: new FormControl("", [Validators.required]),
      gender: new FormControl("", [Validators.required]),
      birthday: new FormControl("", [Validators.required]),
      sdt: new FormControl("", [Validators.required]),
      typeCustomer: new FormControl("", [Validators.required])
    })
  }

  chooseType(value: string) {
    this.tempType = value;
  }

  onSubmit() {
    if (this.createForm.valid) {
      this._customerService.save(this.createForm.value).subscribe(data => {
        this._router.navigateByUrl("home");
      })
    }
  }

}
