import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { take } from 'rxjs/operators';

import { Credentials } from 'src/app/auth/types/credentials';

import { signInRequest } from 'src/app/auth/store/auth.actions';
import { AuthState } from 'src/app/auth/store/auth.reducers';
import { error, isLoading, token } from 'src/app/auth/store/auth.selectors';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss'],
})
export class SignInComponent implements OnInit {
  form: FormGroup;

  isLoading$ = this.store.select(isLoading);

  error$ = this.store.select(error);

  token$ = this.store.select(token);

  constructor(
    private formBuilder: FormBuilder,
    private store: Store<AuthState>,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.token$.pipe(take(1)).subscribe((token) => {
      if (token) this.router.navigate(['/']);
    });
  }

  onSubmit() {
    if (this.form.invalid) return;

    const credentials: Credentials = this.form.getRawValue();

    this.store.dispatch(signInRequest({ credentials }));
  }
}
