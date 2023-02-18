import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  UrlTree,
} from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { AuthState } from 'src/app/auth/store/auth.reducers';
import { isAdmin } from 'src/app/auth/store/auth.selectors';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  isAdmin$ = this.store.select(isAdmin);

  constructor(private store: Store<AuthState>, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    return this.isAdmin$.pipe(
      tap((isAdmin) => {
        if (!isAdmin) this.router.navigate(['/access-denied']);
      })
    );
  }
}
