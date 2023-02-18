import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PathNotFoundComponent } from 'src/app/shared/modules/path-not-found/components/path-not-found/path-not-found.component';

@NgModule({
  declarations: [PathNotFoundComponent],
  imports: [CommonModule],
  exports: [PathNotFoundComponent],
})
export class PathNotFoundModule {}
