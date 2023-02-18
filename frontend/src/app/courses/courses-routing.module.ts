import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CoursesComponent } from 'src/app/courses/components/courses/courses.component';
import { CourseFormComponent } from './components/course-form/course-form.component';

import { RoleGuard } from '../auth/guards/role.guard';

const routes: Routes = [
  { path: '', component: CoursesComponent },
  { path: 'new', component: CourseFormComponent, canActivate: [RoleGuard] },
  { path: ':id', component: CourseFormComponent, canActivate: [RoleGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CoursesRoutingModule {}
