import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../module/customer';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.scss']
})
export class CustomerDeleteComponent implements OnInit {
  public customerDelete: Customer;

  constructor(private _customerService: CustomerService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this._customerService.getCustomerByIndex(index).subscribe(data => {
      this.customerDelete = data;
    })
  }

  onDelete() {
    this._customerService.delete(this.customerDelete.id).subscribe(data => {
      this._router.navigateByUrl("home");
    })
  }

}
