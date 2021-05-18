import { Component, OnInit } from '@angular/core';
import {Customer} from '../module/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  public customerEdit: Customer;
  public typeCustomers: string[] = ["Diamond", "Gold", "Silver"];
  public tempType: string;
  public editForm: FormGroup;

  constructor(private _customerService: CustomerService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this._customerService.getCustomerByIndex(index).subscribe(data => {
      this.customerEdit = data;
      this.editFormFunction();
    })
  }

  editFormFunction() {
    this.editForm = new FormGroup({
      id: new FormControl(this.customerEdit.id),
      nameCustomer: new FormControl(this.customerEdit.nameCustomer, [Validators.required]),
      gender: new FormControl(this.customerEdit.gender),
      birthday: new FormControl(this.customerEdit.birthday, [Validators.required]),
      sdt: new FormControl(this.customerEdit.sdt, [Validators.required]),
      typeCustomer: new FormControl(this.customerEdit.typeCustomer, [Validators.required])
    })
  }

  chooseType(value: string) {
    this.tempType = value;
  }

  onEdit() {
    if (this.editForm.valid) {
      this._customerService.update(this.editForm.value, this.customerEdit.id).subscribe(data => {
        this._router.navigateByUrl("home");
      })
    }
  }

}
