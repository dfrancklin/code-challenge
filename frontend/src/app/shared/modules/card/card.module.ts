import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CardComponent } from 'src/app/shared/modules/card/components/card/card.component';

@NgModule({
  declarations: [CardComponent],
  imports: [CommonModule],
  exports: [CardComponent],
})
export class CardModule {}
