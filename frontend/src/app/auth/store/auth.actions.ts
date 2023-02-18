import { createAction, props } from '@ngrx/store';

import { AuthResponse } from 'src/app/auth/types/auth-response';
import { Credentials } from 'src/app/auth/types/credentials';
import { SignUpData } from 'src/app/auth/types/sign-up-data';

export enum ActionTypes {
  SIGN_IN_REQUEST = 'SIGN_IN_REQUEST',
  SIGN_IN_SUCCESS = 'SIGN_IN_SUCCESS',
  SIGN_IN_FAILURE = 'SIGN_IN_FAILURE',
  SIGN_UP_REQUEST = 'SIGN_UP_REQUEST',
  SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS',
  SIGN_UP_FAILURE = 'SIGN_UP_FAILURE',
  LOGOUT = 'LOGOUT',
}

export const signInRequest = createAction(
  ActionTypes.SIGN_IN_REQUEST,
  props<{ credentials: Credentials }>()
);

export const signInSuccess = createAction(
  ActionTypes.SIGN_IN_SUCCESS,
  props<{ authResponse: AuthResponse }>()
);

export const signInFailure = createAction(
  ActionTypes.SIGN_IN_FAILURE,
  props<{ error: Error }>()
);

export const signUpRequest = createAction(
  ActionTypes.SIGN_UP_REQUEST,
  props<{ signUpData: SignUpData }>()
);

export const signUpSuccess = createAction(
  ActionTypes.SIGN_UP_SUCCESS,
  props<{ authResponse: AuthResponse }>()
);

export const signUpFailure = createAction(
  ActionTypes.SIGN_UP_FAILURE,
  props<{ error: Error }>()
);

export const logout = createAction(ActionTypes.LOGOUT);
