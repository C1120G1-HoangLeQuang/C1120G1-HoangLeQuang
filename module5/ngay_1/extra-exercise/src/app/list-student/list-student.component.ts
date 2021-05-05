import { Component, OnInit } from '@angular/core';

export interface IStudent {
  id: number;
  name: string;
  mark: number;
  image: string;
}

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss']
})
export class ListStudentComponent implements OnInit {
  student: IStudent = {
    id: 1,
    name: 'Nguyen Van A',
    mark: 0,
    image: ''
  };

  constructor() { }

  ngOnInit(): void {
  }

}
