import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cargador',
  templateUrl: './cargador.component.html',
  styleUrls: ['./cargador.component.sass']
})
export class CargadorComponent implements OnInit {

  abierto = false;

  constructor() { }

  ngOnInit(): void {
    window.addEventListener('CARGADOR', (event: CustomEvent) => {
      this.abierto = event.detail;
    });
  }

}
