import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerDeleteComponent} from './customer-delete/customer-delete.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';


const routes: Routes = [
  {path: "home", component: CustomerListComponent},
  {path: "create", component: CustomerCreateComponent},
  {path: "home/edit/:id", component: CustomerEditComponent},
  {path: "home/detail/:id", component: CustomerDetailComponent},
  {path: "home/delete/:id", component: CustomerDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
