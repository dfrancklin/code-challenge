import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';

import { AuthRoutingModule } from 'src/app/auth/auth-routing.module';
import { CardModule } from 'src/app/shared/modules/card/card.module';
import { FormErrorsModule } from 'src/app/shared/modules/form-errors/form-errors.module';

import { AuthEffects } from 'src/app/auth/store/auth.effects';
import { authReducers } from 'src/app/auth/store/auth.reducers';

import { authInterceptorProvider } from 'src/app/auth/interceptors/auth.interceptor';

import { SignInComponent } from 'src/app/auth/components/sign-in/sign-in.component';
import { SignUpComponent } from 'src/app/auth/components/sign-up/sign-up.component';

@NgModule({
  declarations: [SignUpComponent, SignInComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AuthRoutingModule,
    StoreModule.forFeature('auth', authReducers),
    EffectsModule.forFeature([AuthEffects]),
    CardModule,
    FormErrorsModule,
  ],
  providers: [authInterceptorProvider],
})
export class AuthModule {}
