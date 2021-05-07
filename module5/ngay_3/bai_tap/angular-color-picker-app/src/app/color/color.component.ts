import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.scss']
})
export class ColorComponent implements OnInit {
  color: string[] = ['#7489ff', '#43d65d', '#d65943', '#d643a7'];
  // selectColor: string;
  //
  // colorPicker(color: string) {
  //   switch (color) {
  //     case '#7489ff' :
  //       this.selectColor = color;
  //       break;
  //     case '#43d65d' :
  //       this.selectColor = color;
  //       break;
  //     case '#d65943' :
  //       this.selectColor = color;
  //       break;
  //     case '#d643a7' :
  //       this.selectColor = color;
  //       break;
  //   }
  // }
  tempColor: string;

  constructor() { }

  ngOnInit(): void {
  }

  changeColor(value: any) {
    this.tempColor = value;
  }
}
