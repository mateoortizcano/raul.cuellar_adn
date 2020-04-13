import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { SprintService } from '@sprint/shared/service/sprint.service';
import { Sprint } from '@sprint/shared/model/sprint';

@Component({
  selector: 'app-listar-sprint',
  templateUrl: './listar-sprint.component.html',
  styleUrls: ['./listar-sprint.component.sass']
})
export class ListarSprintComponent implements OnInit {
  public listaSprints: Observable<Sprint[]>;

  constructor(protected SprintService: SprintService) { }

  ngOnInit() {
    this.listaSprints = this.SprintService.consultar();
  }

}
