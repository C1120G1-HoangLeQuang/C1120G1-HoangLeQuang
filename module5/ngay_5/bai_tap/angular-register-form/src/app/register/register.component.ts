import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import { Register } from '../register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  rfRegister = FormGroup;
  public country: string[] = ['VN', 'USA', 'CN', 'AU'];
  public tempCountry: string;

  constructor() { }

  ngOnInit(): void {
    // @ts-ignore
    this.rfRegister = new FormGroup({
      email: new FormControl('', [Validators.email, Validators.required]),
      password: new FormControl('', [Validators.minLength(6), Validators.required]),
      confirmPassword: new FormControl('', this.checkPasswords),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', this.checkDateOfBirth),
      gender: new FormControl(''),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }
  checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    const password = group.get('password').value;
    const confirmPassword = group.get('confirmPassword').value;
    return password === confirmPassword ? null : { notSame: true };
  }

  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value;
    const year = Number(value.substr(0, 4));
    return new Date().getFullYear() - year >= 18 ? null : {errorAge : true};
  }

  chooseCountry(value: string) {
    this.tempCountry = value;
  }

}
