import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from '@home/home.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { PresupuestoModule } from '@presupuesto/presupuesto.module';
import { SprintModule } from '@sprint/sprint.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    PresupuestoModule,
    SprintModule
],
  providers: [CookieService],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
