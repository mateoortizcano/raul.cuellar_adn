import { Component, OnInit } from '@angular/core';
import { AlertaService } from '@core/services/alerta.service';
import { Subscription } from 'rxjs';
import { Alerta } from '@core/modelo/alerta';

@Component({
  selector: 'app-alerta',
  templateUrl: './alerta.component.html',
  styleUrls: ['./alerta.component.sass']
})
export class AlertaComponent implements OnInit {

  subscription: Subscription;
  alertas: Alerta[] = [];

  constructor(public alertaService: AlertaService) {
    window.addEventListener('ALERTA', (event: CustomEvent) => {
      this.alertas.push(event.detail);
      setTimeout(() => { this.alertas.shift(); }, 10000);
    });
  }

  ngOnInit(): void {
  }


}
