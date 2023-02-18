import { Component } from '@angular/core';
import { Store } from '@ngrx/store';

import { logout } from 'src/app/auth/store/auth.actions';
import { AuthState } from 'src/app/auth/store/auth.reducers';
import { isAdmin, token } from 'src/app/auth/store/auth.selectors';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  token$ = this.store.select(token);

  isAdmin$ = this.store.select(isAdmin);

  menu = [
    { path: '/courses', name: 'Course' },
    { path: '/students', name: 'Students', adminOnly: true },
  ];

  constructor(private store: Store<AuthState>) {}

  onLogout() {
    const confirmation = confirm('Are you sure?');

    if (!confirmation) return;

    this.store.dispatch(logout());
  }
}
