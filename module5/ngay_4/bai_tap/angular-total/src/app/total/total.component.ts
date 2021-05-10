import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-total',
  templateUrl: './total.component.html',
  styleUrls: ['./total.component.scss']
})
export class TotalComponent implements OnInit {
  // tslint:disable-next-line:variable-name no-input-rename
  @Input('total_1') total_child: number;

  constructor() { }

  ngOnInit(): void {
  }

}
