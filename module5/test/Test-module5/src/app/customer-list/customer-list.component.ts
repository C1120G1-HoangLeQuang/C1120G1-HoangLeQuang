import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';
import {Customer} from '../module/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  private _customerList: Customer[] = [];
  keySearch = "";
  optionSearch = 1;

  constructor(private _customerService: CustomerService,
              private _router: Router) { }

  ngOnInit(): void {
    this._customerService.customers.subscribe(data => {
      this._customerList = data;
    })
  }


  get customerList(): Customer[] {
    return this._customerList;
  }

  search() {
    if (this.optionSearch == 1) {
      this._customerService.searchByName(this.keySearch).subscribe(data => {
        this._customerList = data;
      })
    } else {
      this._customerService.searchByType(this.keySearch).subscribe(data => {
        this._customerList = data;
      })
    }
  }
}
