import { createReducer, on } from '@ngrx/store';

import { ApiResponse } from 'src/app/shared/types/api-response';

import { Course } from 'src/app/courses/types/course';

import * as CoursesActions from 'src/app/courses/store/courses.actions';

export interface CoursesState {
  response: ApiResponse<Course> | null;
  loading: boolean;
  error: Error | null;
}

export const initialState: CoursesState = {
  response: null,
  loading: false,
  error: null,
};

export const coursesReducers = createReducer(
  initialState,
  on(CoursesActions.coursesRequest, (state) => ({ ...state, loading: true })),
  on(CoursesActions.coursesSuccess, (state, { response }) => ({
    ...state,
    loading: false,
    response,
  })),
  on(CoursesActions.coursesFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error,
  }))
);
