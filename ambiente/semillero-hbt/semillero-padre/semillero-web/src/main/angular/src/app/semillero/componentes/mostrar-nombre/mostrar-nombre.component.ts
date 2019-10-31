import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-mostrar-nombre',
  templateUrl: './mostrar-nombre.component.html',
  styleUrls: ['./mostrar-nombre.component.css']
})

export class MostrarNombreComponent implements OnInit {

  nombre= "Andrés Garcés Candamil";
  ciudad = "Manizales";
  repositorio = "https://github.com/andres1147/gitAndresGarces.git";

  constructor() { }

  ngOnInit() {
  }

}
