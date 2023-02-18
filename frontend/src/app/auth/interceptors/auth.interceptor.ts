import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { AuthState } from 'src/app/auth/store/auth.reducers';
import { token } from 'src/app/auth/store/auth.selectors';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  token$ = this.store.select(token);

  constructor(private store: Store<AuthState>) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    return this.token$.pipe(
      switchMap((token) => {
        if (!token) {
          return next.handle(request);
        }

        const headers = request.headers.append(
          'authorization',
          `Bearer ${token}`
        );

        const requestWithAuth = request.clone({ headers });

        return next.handle(requestWithAuth);
      })
    );
  }
}

export const authInterceptorProvider = {
  provide: HTTP_INTERCEPTORS,
  useClass: AuthInterceptor,
  multi: true,
};
