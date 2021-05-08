import {Component, Input, OnInit} from '@angular/core';
import { Student } from '../module/Student';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.scss']
})
export class StudentDetailComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('studentXX') studentDetail1: Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
