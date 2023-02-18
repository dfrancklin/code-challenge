import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';

import { CoursesService } from 'src/app/courses/services/courses.service';

import { Course } from 'src/app/courses/types/course';
import { ApiResponse } from 'src/app/shared/types/api-response';

import * as CoursesActions from 'src/app/courses/store/courses.actions';

@Injectable()
export class CoursesEffects {
  request$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CoursesActions.coursesRequest),
      switchMap(({ page }) => this.courses.load(page)),
      map((response: ApiResponse<Course>) =>
        CoursesActions.coursesSuccess({ response })
      ),
      catchError(({ error }: HttpErrorResponse) =>
        of(CoursesActions.coursesFailure({ error }))
      )
    )
  );

  constructor(private actions$: Actions, private courses: CoursesService) {}
}
