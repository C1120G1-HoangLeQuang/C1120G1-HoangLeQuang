import { Component, OnInit } from '@angular/core';
import {ProjectService} from "../service/project.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Project} from "../model/project";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-project-create',
  templateUrl: './project-create.component.html',
  styleUrls: ['./project-create.component.scss']
})
export class ProjectCreateComponent implements OnInit {
  public nameGroups: string[] = ["Group 1", "Group 2", "Group 3"];
  public tempGroup: string;
  public nameTeachers: string[] = ["Hoang Le Quang", "Tran Quoc Hoang", "Nguyen Ngoc Thuan"];
  public tempTeacher: string;
  public createForm: FormGroup;

  constructor(private _projectService: ProjectService,
              private _router: Router) { }

  ngOnInit(): void {
    this.createProjectFunction();
  }

  createProjectFunction() {
    this.createForm = new FormGroup({
      nameStudent: new FormControl("", [Validators.required]),
      nameGroup: new FormControl("", [Validators.required]),
      nameProject: new FormControl("", [Validators.required]),
      nameTeacher: new FormControl("", [Validators.required]),
      email: new FormControl("", [Validators.required, Validators.pattern("^[a-z][a-z0-9_\\.]{5,32}@[def]{2,}(\\.[a-z0-9]{2,4}){1,2}$")]),
      phone: new FormControl("", [Validators.required, Validators.pattern("^[\\d]{10,12}$")]),
    });
  }

  chooseGroup(value: string) {
    this.tempGroup = value;
  }

  chooseTeacher(value: string) {
    this.tempTeacher = value;
  }

  onSubmit() {
    if (this.createForm.valid) {
      this._projectService.save(this.createForm.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      });
    }
  }

}
