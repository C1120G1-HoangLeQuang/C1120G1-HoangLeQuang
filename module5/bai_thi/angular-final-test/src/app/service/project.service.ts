import { Injectable } from '@angular/core';
import {Project} from '../model/project';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private _projects: Project[] = [];
  private API_URL = "http://localhost:8080/home";

  // httpOptions = {
  //   headers: new HttpHeaders({
  //     'Content-Type': 'application/json'
  //   }),
  //   'Access-Control-Allow-Origin': 'http://localhost:4200',
  //   'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  // };


  constructor(private _httpClient: HttpClient) { }


  getProjects(): Observable<Project[]> {
    return this._httpClient.get<Project[]>(this.API_URL);
  }

  getProjectByIndex(id: number): Observable<Project> {
    return this._httpClient.get<Project>(`${this.API_URL}/${id}`);
  }

  save(project: Project): Observable<Project> {
    return this._httpClient.post<Project>(this.API_URL + "/create", project);
  }

  update(project: Project, id: number): Observable<Project> {
    return this._httpClient.put<Project>(`${this.API_URL}/edit/${id}`, project);
  }

  delete(id: number): Observable<Project> {
    return this._httpClient.delete<Project>(`${this.API_URL}/delete/${id}`);
  }

  searchByStudent(student: string, teacher: string): Observable<Project[]> {
    return this._httpClient.get<Project[]>(this.API_URL + "/searchStudent?nameStudent=" + student + "&nameTeacher=" + teacher);
  }

  // searchByTeacher(teacher: string): Observable<Project[]> {
  //   return this._httpClient.get<Project[]>(this.API_URL + "/searchTeacher?nameTeacher_like=" + teacher);
  // }
}
