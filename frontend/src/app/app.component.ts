import { Component } from '@angular/core';
import { Store } from '@ngrx/store';

import { token } from 'src/app/auth/store/auth.selectors';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  token$ = this.store.select(token);

  constructor(private store: Store) {}
}
