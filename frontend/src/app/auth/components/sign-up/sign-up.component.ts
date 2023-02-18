import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { take } from 'rxjs/operators';

import { SignUpData } from 'src/app/auth/types/sign-up-data';

import { signUpRequest } from 'src/app/auth/store/auth.actions';
import { AuthState } from 'src/app/auth/store/auth.reducers';
import { error, isLoading, token } from 'src/app/auth/store/auth.selectors';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss'],
})
export class SignUpComponent implements OnInit {
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
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      birthDate: ['', [Validators.required, this.checkAge]],
      address: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      zipCode: ['', Validators.required],
      email: ['', [Validators.email, Validators.required]],
      phoneNumber: ['', Validators.required],
      password: ['', Validators.required],
      passwordConfirmation: [
        '',
        [Validators.required, this.equalsTo('password')],
      ],
    });
  }

  ngOnInit(): void {
    this.token$.pipe(take(1)).subscribe((token) => {
      if (token) this.router.navigate(['/']);
    });
  }

  onSubmit() {
    if (this.form.invalid) return;

    const signUpData: SignUpData = this.form.getRawValue();

    this.store.dispatch(signUpRequest({ signUpData }));
  }

  checkAge(control: FormControl) {
    const birthDate = Date.parse(`${control.value}T00:00`);
    const ageLimit = 1000 * 60 * 60 * 24 * 365 * 16;
    const limitDate = Date.now() - ageLimit;

    if (birthDate > limitDate) return { ageLimit: true };

    return null;
  }

  equalsTo(otherField: string) {
    return (control: FormControl) => {
      const otherControl = control.root.get(otherField);

      if (!otherControl) return null;

      otherControl.valueChanges
        .pipe(take(1))
        .subscribe(() => control.updateValueAndValidity());

      if (control.value === otherControl.value) return null;

      return { equalsTo: true };
    };
  }
}
