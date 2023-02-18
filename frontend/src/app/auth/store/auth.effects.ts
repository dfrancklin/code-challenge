import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import { catchError, map, switchMap, tap } from 'rxjs/operators';

import { AuthService } from 'src/app/auth/services/auth.service';

import { AuthResponse } from 'src/app/auth/types/auth-response';

import * as AuthActions from 'src/app/auth/store/auth.actions';

@Injectable()
export class AuthEffects {
  signIn$ = createEffect(() =>
    this.actions$.pipe(
      ofType(AuthActions.signInRequest),
      switchMap(({ credentials }) => this.authService.signIn(credentials)),
      map((authResponse: AuthResponse) =>
        AuthActions.signInSuccess({ authResponse })
      ),
      catchError(({ error }: HttpErrorResponse) =>
        of(AuthActions.signInFailure({ error }))
      )
    )
  );

  signUp$ = createEffect(() =>
    this.actions$.pipe(
      ofType(AuthActions.signUpRequest),
      switchMap(({ signUpData }) => this.authService.signUp(signUpData)),
      map((authResponse: AuthResponse) =>
        AuthActions.signUpSuccess({ authResponse })
      ),
      catchError(({ error }: HttpErrorResponse) =>
        of(AuthActions.signUpFailure({ error }))
      )
    )
  );

  redirectOnSuccess$ = createEffect(
    () =>
      this.actions$.pipe(
        ofType(AuthActions.signUpSuccess, AuthActions.signInSuccess),
        tap(() => this.router.navigate(['/']))
      ),
    { dispatch: false }
  );

  redirectOnLogout$ = createEffect(
    () =>
      this.actions$.pipe(
        ofType(AuthActions.logout),
        tap(() => this.router.navigate(['/auth/sign-in']))
      ),
    { dispatch: false }
  );

  constructor(
    private actions$: Actions,
    private authService: AuthService,
    private router: Router
  ) {}
}
