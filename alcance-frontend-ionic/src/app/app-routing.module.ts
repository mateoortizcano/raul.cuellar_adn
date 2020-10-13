import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'listado-proyectos',
    pathMatch: 'full'
  },
  {
    path: 'listado-proyectos',
    loadChildren: () => import('./paginas/listado-proyectos/listado-proyectos.module').then(m => m.ListadoProyectosPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
