import { Component, OnInit } from '@angular/core';
import {Customer} from '../module/customer';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {
  public customer: Customer;

  constructor(private _customerService: CustomerService,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this._customerService.getCustomerByIndex(index).subscribe(data => {
      this.customer = data;
    })
  }

}
