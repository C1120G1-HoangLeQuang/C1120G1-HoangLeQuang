import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectListComponent} from './project-list/project-list.component';
import {ProjectEditComponent} from './project-edit/project-edit.component';
import {ProjectDeleteComponent} from './project-delete/project-delete.component';
import {ProjectCreateComponent} from "./project-create/project-create.component";


const routes: Routes = [
  {path: "home", component: ProjectListComponent},
  {path: "create", component: ProjectCreateComponent},
  {path: "home/edit/:id", component: ProjectEditComponent},
  {path: "home/delete/:id", component: ProjectDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
