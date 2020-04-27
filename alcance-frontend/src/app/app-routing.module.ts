import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityGuard } from '@core/guard/security.guard';
import { HomeComponent } from '@home/home.component';


const routes: Routes = [
  { path: '', redirectTo: '/proyecto', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate: [SecurityGuard]  },
  // { path: 'sprint', loadChildren: () => import('@sprint/sprint.module').then(mod => mod.SprintModule) },
  { path: 'proyecto', loadChildren: () => import('@proyecto/proyecto.module').then(mod => mod.ProyectoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
