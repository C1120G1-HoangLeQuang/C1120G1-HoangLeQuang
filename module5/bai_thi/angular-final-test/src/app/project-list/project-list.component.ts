import { Component, OnInit } from '@angular/core';
import {Project} from '../model/project';
import {ProjectService} from '../service/project.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})
export class ProjectListComponent implements OnInit {
  private _projectList: Project[] = [];
  keySearch = "";
  keySearch2 = "";

  constructor(private _projectService: ProjectService,
              private _router: Router) { }

  ngOnInit(): void {
    this._projectService.getProjects().subscribe(data => {
      this._projectList = data;
    })
  }


  get projectList(): Project[] {
    return this._projectList;
  }

  search() {
    this._projectService.searchByStudent(this.keySearch, this.keySearch2).subscribe(data => {
      this._projectList = data;
    });
    // if (this.optionSearch == 1) {
    //   this._projectService.searchByStudent(this.keySearch).subscribe(data => {
    //     this._projectList = data;
    //   });
    // } else {
    //   this._projectService.searchByTeacher(this.keySearch).subscribe(data => {
    //     this._projectList = data;
    //   });
    // }
  }
}
