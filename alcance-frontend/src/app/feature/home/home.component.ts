import { Component, OnInit } from '@angular/core';
import { AlertaService } from '@core/services/alerta.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {


  constructor(
    public alertaService: AlertaService
  ) { }

  ngOnInit() {
    this.alertaService.success("Se realizó correctamente otra vez");
  }

}
