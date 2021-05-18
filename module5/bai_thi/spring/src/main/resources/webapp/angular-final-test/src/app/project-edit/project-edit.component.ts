import { Component, OnInit } from '@angular/core';
import {Project} from '../model/project';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ProjectService} from '../service/project.service';

@Component({
  selector: 'app-project-edit',
  templateUrl: './project-edit.component.html',
  styleUrls: ['./project-edit.component.scss']
})
export class ProjectEditComponent implements OnInit {
  public projectEdit: Project;
  public nameGroups: string[] = ["Group 1", "Group 2", "Group 3"];
  public tempGroup: string;
  public nameTeachers: string[] = ["Hoang Le Quang", "Tran Quoc Hoang", "Nguyen Ngoc Thuan"];
  public tempTeacher: string;
  public editForm: FormGroup;

  constructor(private _projectService: ProjectService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    this._projectService.getProjectByIndex(index).subscribe(data => {
      this.projectEdit = data;
      this.editFormFunction();
    })
  }

  editFormFunction() {
    this.editForm = new FormGroup({
      id: new FormControl(this.projectEdit.id),
      nameStudent: new FormControl(this.projectEdit.nameStudent, [Validators.required]),
      nameGroup: new FormControl(this.projectEdit.nameGroup, [Validators.required]),
      nameProject: new FormControl(this.projectEdit.nameProject, [Validators.required]),
      nameTeacher: new FormControl(this.projectEdit.nameTeacher, [Validators.required]),
      email: new FormControl(this.projectEdit.email, [Validators.required, Validators.pattern("^[a-z][a-z0-9_\\.]{5,32}@[def]{2,}(\\.[a-z0-9]{2,4}){1,2}$")]),
      phone: new FormControl(this.projectEdit.phone, [Validators.required, Validators.pattern("^[\\d]{10,12}$")]),
    })
  }

  chooseGroup(value: string) {
    this.tempGroup = value;
  }

  chooseTeacher(value: string) {
    this.tempTeacher = value;
  }

  onEdit() {
    if (this.editForm.valid) {
      this._projectService.update(this.editForm.value, this.projectEdit.id).subscribe(data => {
        this._router.navigateByUrl("home");
      })
    }
  }

}
