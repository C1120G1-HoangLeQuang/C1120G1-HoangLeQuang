import { Component } from '@angular/core';
import { Student } from './module/Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'demo-InOut';

  public students: Student[] = [
    new Student('Nguyen Van A', 0, 50),
    new Student('Nguyen Van B', 1, 85),
    new Student('Nguyen Van C', 2, 70),
    new Student('Nguyen Van D', 0, 90)
  ];
  public student: Student | undefined; // new nhu khong co thi se undefined

  // tung item = 1 doi tuong student
  showDetail(item: Student) {
    this.student = item;
  }
  // phuong thuc nay dung de push 1 doi tuong vao mang $event = value(doi tuong truyen vao mang) unshift = push
  onGetStudent($event: Student) {
    this.students.unshift($event);
  }
}
