import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Alerta } from '@core/modelo/alerta.model';
import { AlertaService } from '@core/services/alerta.service';

@Component({
  selector: 'lib-alerta',
  templateUrl: './alerta.component.html',
  styleUrls: ['./alerta.component.sass']
})

export class AlertaLibComponent implements OnInit {

  subscription: Subscription;
  alertas: Alerta[] = [];

  constructor(public alertaService: AlertaService) {
    window.addEventListener('ALERTA', (event: CustomEvent) => {
      if (!!event.detail) {
        if (event.detail.timeout < 0) {
          this.alertas = [];
        } else {
          this.alertas.push(event.detail);
        }
        this.mostrarAlerta();
      }
    });
  }

  ngOnInit() {
  }

  mostrarAlerta() {
    this.alertas.forEach(alert => {
      if (alert.timeout > 0) {
        setTimeout(() => { this.removerAlerta(alert); }, alert.timeout);
      }
    });
  }

  removerAlerta(alerta: Alerta) {
    const alertasFiltradas = this.alertas.filter(alert => alert !== alerta);
    this.alertas = alertasFiltradas;
    this.alertaService.clear();
  }
}
