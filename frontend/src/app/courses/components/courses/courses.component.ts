import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { take } from 'rxjs/operators';
import { isAdmin } from 'src/app/auth/store/auth.selectors';

import { coursesRequest } from 'src/app/courses/store/courses.actions';
import { CoursesState } from 'src/app/courses/store/courses.reducers';
import {
  courses,
  currentPage,
  error,
  isFirstPage,
  isLastPage,
  isLoading,
  totalElements,
  totalPages,
} from 'src/app/courses/store/courses.selectors';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  isLoading$ = this.store.select(isLoading);

  courses$ = this.store.select(courses);

  currentPage$ = this.store.select(currentPage);

  totalPages$ = this.store.select(totalPages);

  totalElements$ = this.store.select(totalElements);

  isFirstPage$ = this.store.select(isFirstPage);

  isLastPage$ = this.store.select(isLastPage);

  error$ = this.store.select(error);

  isAdmin$ = this.store.select(isAdmin);

  constructor(private store: Store<CoursesState>) {}

  ngOnInit(): void {
    this.store.dispatch(coursesRequest({}));
  }

  onChangePage(change: number) {
    this.currentPage$.pipe(take(1)).subscribe((page) => {
      const newPage = (page ?? 0) + change;

      this.store.dispatch(coursesRequest({ page: newPage }));
    });
  }
}
