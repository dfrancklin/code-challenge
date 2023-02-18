import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';

import { CoursesRoutingModule } from 'src/app/courses/courses-routing.module';

import { CoursesEffects } from 'src/app/courses/store/courses.effects';
import { coursesReducers } from 'src/app/courses/store/courses.reducers';

import { CoursesComponent } from 'src/app/courses/components/courses/courses.component';
import { CardModule } from '../shared/modules/card/card.module';
import { CourseFormComponent } from './components/course-form/course-form.component';

@NgModule({
  declarations: [CoursesComponent, CourseFormComponent],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    StoreModule.forFeature('courses', coursesReducers),
    EffectsModule.forFeature([CoursesEffects]),
    CardModule,
  ],
})
export class CoursesModule {}
