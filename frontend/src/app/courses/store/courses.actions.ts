import { createAction, props } from '@ngrx/store';

import { Course } from 'src/app/courses/types/course';
import { ApiResponse } from 'src/app/shared/types/api-response';

export enum ActionTypes {
  COURSES_REQUEST = 'COURSES_REQUEST',
  COURSES_SUCCESS = 'COURSES_SUCCESS',
  COURSES_FAILURE = 'COURSES_FAILURE',
}

export const coursesRequest = createAction(
  ActionTypes.COURSES_REQUEST,
  props<{ page?: number }>()
);

export const coursesSuccess = createAction(
  ActionTypes.COURSES_SUCCESS,
  props<{ response: ApiResponse<Course> }>()
);

export const coursesFailure = createAction(
  ActionTypes.COURSES_FAILURE,
  props<{ error: Error }>()
);
