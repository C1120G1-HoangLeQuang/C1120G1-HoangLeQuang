import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  inputA = '';
  inputB = '';
  inputRS = '';
  result = parseFloat(this.inputRS);

  Add() {
    const a = parseFloat(this.inputA);
    const b = parseFloat(this.inputB);
    this.result = a + b;
    (document.getElementById('result') as HTMLInputElement).value = this.result + '';

  }
  Sub() {
    const a = parseFloat(this.inputA);
    const b = parseFloat(this.inputB);
    this.result = a - b;
    (document.getElementById('result') as HTMLInputElement).value = this.result + '';
  }

  Multi() {
    const a = parseFloat(this.inputA);
    const b = parseFloat(this.inputB);
    this.result = a * b;
    (document.getElementById('result') as HTMLInputElement).value = this.result + '';
  }

  Div() {
    const a = parseFloat(this.inputA);
    const b = parseFloat(this.inputB);
    this.result = a / b;
    (document.getElementById('result') as HTMLInputElement).value = this.result + '';
  }

  constructor() { }

  ngOnInit(): void {
  }

  updateA(value: string) {
    this.inputA = value;
  }

  updateB(value: string) {
    this.inputB = value;
  }
}
