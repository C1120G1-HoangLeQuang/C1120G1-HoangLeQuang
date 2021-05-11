import { Component } from '@angular/core';
import { Todo } from './todo';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-name-card';
  todos: Todo[] = [];
  content = new FormControl();
  // tslint:disable-next-line:variable-name
  private _id = 1;

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: this._id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }
}
