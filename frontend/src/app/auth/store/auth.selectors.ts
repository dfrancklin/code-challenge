import { createFeatureSelector, createSelector } from '@ngrx/store';

import { AuthState } from 'src/app/auth/store/auth.reducers';

export const authFeatureSelector = createFeatureSelector<AuthState>('auth');

export const isLoading = createSelector(
  authFeatureSelector,
  (state: AuthState) => state.loading
);

export const token = createSelector(
  authFeatureSelector,
  (state: AuthState) => state.token
);

export const isAdmin = createSelector(token, (accessToken: string | null) => {
  if (!accessToken) return false;

  const tokenParts = accessToken.split('.');
  const data = atob(tokenParts[1]);
  const { role } = JSON.parse(data);
  return role === 'ROLE_ADMIN';
});

export const error = createSelector(
  authFeatureSelector,
  (state: AuthState) => state.error
);
