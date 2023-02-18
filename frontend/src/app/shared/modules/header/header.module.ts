import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HeaderComponent } from 'src/app/shared/modules/header/components/header/header.component';

@NgModule({
  declarations: [HeaderComponent],
  imports: [RouterModule, CommonModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
