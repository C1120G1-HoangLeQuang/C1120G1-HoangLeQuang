import { Component, OnInit } from '@angular/core';
import { DictionaryService } from '../../service/dictionary.service';
import {Dictionary} from '../dictionary';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.scss']
})
export class DictionaryPageComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  private _dictionaryList: Dictionary[] = [];

  // tslint:disable-next-line:variable-name
  constructor(private _dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    this._dictionaryList = this._dictionaryService.dictionary;
  }


  get dictionaryList(): Dictionary[] {
    return this._dictionaryList;
  }
}
