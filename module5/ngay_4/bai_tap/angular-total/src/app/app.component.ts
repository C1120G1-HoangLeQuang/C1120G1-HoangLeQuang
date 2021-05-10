import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-total';
  // tslint:disable-next-line:variable-name
  public number_1 = 0;
  // tslint:disable-next-line:variable-name
  public number_2 = 0;
  // tslint:disable-next-line:variable-name
  public total_1 = 0;
  Sub() {
    this.total_1 = this.number_1 + this.number_2;
  }

}
