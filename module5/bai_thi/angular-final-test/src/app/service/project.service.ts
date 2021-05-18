import { Injectable } from '@angular/core';
import {Project} from '../model/project';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private _projects: Project[] = [];
  private API_URL = "http://localhost:8080/projects";

  constructor(private _httpClient: HttpClient) { }


  get projects(): Observable<Project[]> {
    return this._httpClient.get<Project[]>(this.API_URL);
  }

  getProjectByIndex(id: number): Observable<Project> {
    return this._httpClient.get<Project>(`${this.API_URL}/${id}`);
  }

  update(project: Project, id: number): Observable<Project> {
    return this._httpClient.put<Project>(`${this.API_URL}/${id}`, project);
  }

  delete(id: number): Observable<Project> {
    return this._httpClient.delete<Project>(`${this.API_URL}/${id}`);
  }
}
