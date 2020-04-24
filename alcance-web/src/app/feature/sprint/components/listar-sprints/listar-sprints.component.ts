import { Component, OnInit } from '@angular/core';
import { SprintService } from '../../shared/service/sprint.service';
import { Observable } from 'rxjs';
import { Sprint } from '@sprint/shared/model/sprint';

@Component({
  selector: 'app-listar-sprints',
  templateUrl: './listar-sprints.component.html',
  styleUrls: ['./listar-sprints.component.sass']
})
export class ListarSprintsComponent implements OnInit {
  listaSprints: Observable<Sprint[]>;

  constructor(protected sprintService: SprintService) { }

  ngOnInit(): void {
    this.listaSprints = this.sprintService.listar();
  }

}
