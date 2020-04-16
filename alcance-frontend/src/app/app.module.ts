import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from '@home/home.component';
import { ProductoModule } from '@producto/producto.module';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { PresupuestoModule } from '@presupuesto/presupuesto.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AlertaLibComponent } from '@core/components/alertas/alerta.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProductoModule,
    PresupuestoModule,
    CoreModule,
    NgbModule,
    AlertaLibComponent
  ],
  providers: [CookieService],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
