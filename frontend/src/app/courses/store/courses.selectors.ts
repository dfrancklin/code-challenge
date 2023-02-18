import { createFeatureSelector, createSelector } from '@ngrx/store';

import { Course } from 'src/app/courses/types/course';
import { ApiResponse } from 'src/app/shared/types/api-response';

import { CoursesState } from 'src/app/courses/store/courses.reducers';

export const coursesFeatureSelector =
  createFeatureSelector<CoursesState>('courses');

export const isLoading = createSelector(
  coursesFeatureSelector,
  (state: CoursesState) => state.loading
);

export const response = createSelector(
  coursesFeatureSelector,
  (state: CoursesState) => state.response
);

export const courses = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.content
);

export const currentPage = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.number
);

export const totalPages = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.totalPages
);

export const totalElements = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.totalElements
);

export const isFirstPage = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.first
);

export const isLastPage = createSelector(
  response,
  (response: ApiResponse<Course> | null) => response?.last
);

export const error = createSelector(
  coursesFeatureSelector,
  (state: CoursesState) => state.error
);
