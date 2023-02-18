import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppRoutingModule } from 'src/app/app-routing.module';
import { AuthModule } from 'src/app/auth/auth.module';
import { AccessDeniedModule } from 'src/app/shared/modules/access-denied/access-denied.module';
import { HeaderModule } from 'src/app/shared/modules/header/header.module';
import { PathNotFoundModule } from 'src/app/shared/modules/path-not-found/path-not-found.module';

import { AppComponent } from 'src/app/app.component';

import { errorInterceptorProvider } from 'src/app/shared/interceptors/error.interceptor';

import { environment } from 'src/environments/environment';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    StoreModule.forRoot({}, {}),
    EffectsModule.forRoot([]),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
      logOnly: environment.production,
    }),
    AuthModule,
    HeaderModule,
    PathNotFoundModule,
    AccessDeniedModule,
  ],
  providers: [errorInterceptorProvider],
  bootstrap: [AppComponent],
})
export class AppModule {}
