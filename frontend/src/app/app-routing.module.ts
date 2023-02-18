import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccessDeniedComponent } from 'src/app/shared/modules/access-denied/components/access-denied/access-denied.component';
import { PathNotFoundComponent } from 'src/app/shared/modules/path-not-found/components/path-not-found/path-not-found.component';

import { AuthGuard } from 'src/app/auth/guards/auth.guard';
import { RoleGuard } from './auth/guards/role.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('src/app/enrollments/enrollments.module').then(
        (m) => m.EnrollmentsModule
      ),
    canActivate: [AuthGuard],
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('src/app/auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'courses',
    loadChildren: () =>
      import('src/app/courses/courses.module').then((m) => m.CoursesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'students',
    loadChildren: () =>
      import('src/app/students/students.module').then((m) => m.StudentsModule),
    canActivate: [AuthGuard, RoleGuard],
  },
  {
    path: 'access-denied',
    component: AccessDeniedComponent,
  },
  { path: '**', component: PathNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
