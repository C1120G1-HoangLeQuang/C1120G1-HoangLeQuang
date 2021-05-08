export class Student {
  // tslint:disable-next-line:variable-name
  private _id: number;
  // tslint:disable-next-line:variable-name
  private _name: string;
  // tslint:disable-next-line:variable-name
  private _gender: number;
  // tslint:disable-next-line:variable-name
  private _point: number;


  constructor(name: string, gender: number, point: number) {
    this._name = name;
    this._gender = gender;
    this._point = point;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }


  get gender(): number {
    return this._gender;
  }

  set gender(value: number) {
    this._gender = value;
  }

  get point(): number {
    return this._point;
  }

  set point(value: number) {
    this._point = value;
  }

}
