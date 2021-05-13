import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Dictionary} from '../dictionary';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.scss']
})
export class DictionaryDetailComponent implements OnInit {
  public detail: Dictionary;

  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const index = this.activatedRoute.snapshot.params['id'];
    // tslint:disable-next-line:radix
    this.detail = this.dictionaryService.getDetail(parseInt(index));
  }

}
