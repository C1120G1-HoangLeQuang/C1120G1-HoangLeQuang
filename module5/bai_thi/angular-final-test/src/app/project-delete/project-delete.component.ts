import { Component, OnInit } from '@angular/core';
import {Project} from '../model/project';
import {ProjectService} from '../service/project.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-project-delete',
  templateUrl: './project-delete.component.html',
  styleUrls: ['./project-delete.component.scss']
})
export class ProjectDeleteComponent implements OnInit {
  public projectDelete: Project;

  constructor(private _projectService: ProjectService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this._projectService.getProjectByIndex(index).subscribe(data => {
      this.projectDelete = data;
    });
  }

  onDelete() {
    this._projectService.delete(this.projectDelete.id).subscribe(data => {
      this._router.navigateByUrl("home");
    })
  }

}
