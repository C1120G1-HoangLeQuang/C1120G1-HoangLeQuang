export class Customer {
  private _id: number;
  private _nameCustomer: string;
  private _gender: number;
  private _birthday: string;
  private _sdt: string;
  private _typeCustomer: string;


  constructor(id: number, nameCustomer: string, gender: number, birthday: string, sdt: string, typeCustomer: string) {
    this._id = id;
    this._nameCustomer = nameCustomer;
    this._gender = gender;
    this._birthday = birthday;
    this._sdt = sdt;
    this._typeCustomer = typeCustomer;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nameCustomer(): string {
    return this._nameCustomer;
  }

  set nameCustomer(value: string) {
    this._nameCustomer = value;
  }

  get gender(): number {
    return this._gender;
  }

  set gender(value: number) {
    this._gender = value;
  }

  get birthday(): string {
    return this._birthday;
  }

  set birthday(value: string) {
    this._birthday = value;
  }

  get sdt(): string {
    return this._sdt;
  }

  set sdt(value: string) {
    this._sdt = value;
  }

  get typeCustomer(): string {
    return this._typeCustomer;
  }

  set typeCustomer(value: string) {
    this._typeCustomer = value;
  }
}
