import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Student } from '../module/Student';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.scss']
})
export class StudentCreateComponent implements OnInit {
  // tslint:disable-next-line:no-output-on-prefix no-output-rename
  @Output('studentCreate') onCreate = new EventEmitter<Student>();
  public student: Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }


  create(name: string, gender: string, point: string) {
    // tslint:disable-next-line:radix
    this.student = new Student(name, parseInt(gender), parseInt(point));
    this.onCreate.emit(this.student);
  }
}
