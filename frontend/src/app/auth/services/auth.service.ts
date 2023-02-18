import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { AuthResponse } from 'src/app/auth/types/auth-response';
import { Credentials } from 'src/app/auth/types/credentials';
import { SignUpData } from 'src/app/auth/types/sign-up-data';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly basePath = `${environment.apiUrl}/auth`;

  constructor(private http: HttpClient) {}

  signIn(credentials: Credentials): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(
      `${this.basePath}/sign-in`,
      credentials
    );
  }

  signUp(signUpData: SignUpData): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.basePath}/sign-up`, signUpData);
  }
}
