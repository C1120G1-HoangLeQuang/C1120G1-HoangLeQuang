import { Injectable } from '@angular/core';
import { Dictionary } from '../app/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  // tslint:disable-next-line:variable-name
  private _dictionary: Dictionary[] = [
    {id: 1, word: 'Hello', mean: 'Xin Chao'},
    {id: 2, word: 'Book', mean: 'Sach'},
    {id: 3, word: 'Dictionary', mean: 'Tu Dien'}
  ];

  constructor() { }


  get dictionary(): Dictionary[] {
    return this._dictionary;
  }

  getDetail(id: number) {
    for (let i = 0; i <= this._dictionary.length; i++) {
      // tslint:disable-next-line:triple-equals
      if (this._dictionary[i].id == id) {
        return this._dictionary[i];
      }
    }
  }
}
