import { createReducer, on } from '@ngrx/store';

import * as AuthActions from 'src/app/auth/store/auth.actions';

export interface AuthState {
  token: string | null;
  loading: boolean;
  error: Error | null;
}

const ACCESS_TOKEN_KEY = 'access_token';

export const initialState: AuthState = {
  token: localStorage.getItem(ACCESS_TOKEN_KEY),
  loading: false,
  error: null,
};

export const authReducers = createReducer(
  initialState,
  on(AuthActions.signUpRequest, AuthActions.signInRequest, (state) => ({
    ...state,
    loading: true,
  })),
  on(
    AuthActions.signUpSuccess,
    AuthActions.signInSuccess,
    (state, { authResponse }) => {
      localStorage.setItem(ACCESS_TOKEN_KEY, authResponse.accessToken);

      return { ...state, loading: false, token: authResponse.accessToken };
    }
  ),
  on(
    AuthActions.signUpFailure,
    AuthActions.signInFailure,
    (state, { error }) => ({ ...state, loading: false, error })
  ),
  on(AuthActions.logout, (state) => {
    localStorage.removeItem(ACCESS_TOKEN_KEY);

    return { ...state, token: null };
  })
);
