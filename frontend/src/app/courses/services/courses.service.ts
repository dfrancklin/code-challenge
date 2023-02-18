import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Course } from 'src/app/courses/types/course';
import { ApiResponse } from 'src/app/shared/types/api-response';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  private readonly basePath = `${environment.apiUrl}/courses`;

  constructor(private http: HttpClient) {}

  load(page?: number): Observable<ApiResponse<Course>> {
    const params: any = {};

    if (page) params.page = page;

    return this.http.get<ApiResponse<Course>>(this.basePath, { params });
  }
}
