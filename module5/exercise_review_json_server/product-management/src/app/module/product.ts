export class Product {
  // tslint:disable-next-line:variable-name
  private _id: number;
  // tslint:disable-next-line:variable-name
  private _nameProduct: string;
  // tslint:disable-next-line:variable-name
  private _priceProduct: number;
  // tslint:disable-next-line:variable-name
  private _dateRelease: string;
  // tslint:disable-next-line:variable-name
  private _nationRelease: string;
  // tslint:disable-next-line:variable-name
  private _status: number;


  constructor(id: number, nameProduct: string, priceProduct: number, dateRelease: string, nationRelease: string, status: number) {
    this._id = id;
    this._nameProduct = nameProduct;
    this._priceProduct = priceProduct;
    this._dateRelease = dateRelease;
    this._nationRelease = nationRelease;
    this._status = status;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nameProduct(): string {
    return this._nameProduct;
  }

  set nameProduct(value: string) {
    this._nameProduct = value;
  }

  get priceProduct(): number {
    return this._priceProduct;
  }

  set priceProduct(value: number) {
    this._priceProduct = value;
  }

  get dateRelease(): string {
    return this._dateRelease;
  }

  set dateRelease(value: string) {
    this._dateRelease = value;
  }

  get nationRelease(): string {
    return this._nationRelease;
  }

  set nationRelease(value: string) {
    this._nationRelease = value;
  }

  get status(): number {
    return this._status;
  }

  set status(value: number) {
    this._status = value;
  }
}
