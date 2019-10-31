import { Component} from '@angular/core';
/**
 * @description La clase mostrarNombre permite imprimir en pantalla mis datos personales
 * @author Andres Garces
 */
@Component({
  selector: 'app-mostrar-nombre',
  templateUrl: './mostrar-nombre.component.html',
  styleUrls: ['./mostrar-nombre.component.css']
})

export class MostrarNombreComponent {

  nombre= "Andrés Garcés Candamil";
  ciudad = "Manizales";
  repositorio = "https://github.com/andres1147/gitAndresGarces.git";

}
