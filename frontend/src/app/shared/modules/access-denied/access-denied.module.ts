import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AccessDeniedComponent } from 'src/app/shared/modules/access-denied/components/access-denied/access-denied.component';

@NgModule({
  declarations: [AccessDeniedComponent],
  imports: [CommonModule],
  exports: [AccessDeniedComponent],
})
export class AccessDeniedModule {}
