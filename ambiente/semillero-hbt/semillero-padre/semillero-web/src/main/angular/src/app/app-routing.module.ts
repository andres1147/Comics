import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { GestionarUsuarioComponent } from './semillero/componentes/gestionarUsuario/gestionar-usuario';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },

  //Se debe incluir el componente para que se le pueda hacer routing o navegacion entre paginas
  { path: 'gestionar-usuario', component: GestionarUsuarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
