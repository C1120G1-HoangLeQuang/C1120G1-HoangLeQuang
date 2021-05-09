import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.scss']
})
export class CountdownTimerComponent implements OnInit {
  // tslint:disable-next-line:only-arrow-functions
  // public count: number;
  // public message = 'Hello World';


  constructor() { }
  // getValue(value: number) {
  //   (document.getElementById('number') as HTMLInputElement).value = this.count + '';
  //   this.count--;
  //   this.count = value;
  // }
  // @ts-ignore
  private clear: NodeJS.Timeout;

  ngOnInit(): void {
  }

  start() {
    // tslint:disable-next-line:only-arrow-functions
    this.clear = setInterval(function() {
     alert('Count have been done');
    }, 5000);
  }

  stop() {
    // @ts-ignore
    clearInterval(this.clear);
  }

  reset() {
    // tslint:disable-next-line:only-arrow-functions
    this.clear = setInterval(function() {
      alert('Count have been done');
    }, 5000);
  }
}
