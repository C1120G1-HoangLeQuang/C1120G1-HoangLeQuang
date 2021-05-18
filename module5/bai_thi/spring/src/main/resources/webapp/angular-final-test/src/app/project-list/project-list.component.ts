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

  constructor(private _projectService: ProjectService,
              private _router: Router) { }

  ngOnInit(): void {
    this._projectService.projects.subscribe(data => {
      this._projectList = data;
    })
  }


  get projectList(): Project[] {
    return this._projectList;
  }
}
