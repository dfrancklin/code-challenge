import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { StudentsComponent } from 'src/app/students/components/students/students.component';
import { StudentsRoutingModule } from 'src/app/students/students-routing.module';

@NgModule({
  declarations: [StudentsComponent],
  imports: [CommonModule, StudentsRoutingModule],
})
export class StudentsModule {}
