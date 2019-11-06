import { Component, OnInit} from '@angular/core';
import { Comic } from '../../comicEjercicio/comic';
/**
 * @description La clase mostrarNombre permite imprimir en pantalla mis datos personales
 * @author Andres Garces
 */
@Component({
  selector: 'app-mostrar-nombre',
  templateUrl: './mostrar-nombre.component.html',
  styleUrls: ['./mostrar-nombre.component.css']
})

export class MostrarNombreComponent implements OnInit {

  isLogged = false;

  public listaComics :Array<Comic> = [
    {id : 1, nombre : "Batman", editorial : "Marvel", tematica : "Acción",
    numeroPaginas : 50, precio : "60,500.99", autores : "Pedrito Barrera",
    aColor : true, fechaVenta : new Date('10-10-2019'), estado : "activo"},

    {id : 2, nombre : "Predicador", editorial : "Vertigo", tematica : "Terror",
    numeroPaginas : 32, precio : "5,500", autores : "Garth Ennis",
    aColor : false, fechaVenta : new Date('12-05-2013'), estado : "inactivo"},

    {id : 3, nombre : "Akira", editorial : "Kodansha", tematica : "Romántica",
    numeroPaginas : 17, precio : "17,100", autores : "Katsuhiro Otomo",
    aColor : true, fechaVenta : new Date('02-07-2005'), estado : "activo"},

    {id : 4, nombre : "Persépolis", editorial : "L'Association", tematica : "Suspenso",
    numeroPaginas : 65, precio : "44,120", autores : "Marjane Satrapi",
    aColor : false, fechaVenta : new Date('11-09-2015'), estado : "inactivo"},

    {id : 5, nombre : "Parker", editorial : "IDW", tematica : "Drama",
    numeroPaginas : 75, precio : "75,110", autores : "Darwyn Cooke",
    aColor : true, fechaVenta : new Date('04-10-2017'), estado : "activo"}
  ];
  
  ngOnInit(): void {
  }

  hola = JSON.stringify(this.listaComics);  
  comicEliminado : string;
  mostrarMensaje = false;
  cantidad = this.listaComics.length;

  nombre= "Andrés Garcés Candamil";
  ciudad = "Manizales";
  repositorio = "https://github.com/andres1147/gitAndresGarces.git";

  public holaaa() : void{
    this.mostrarMensaje = true;
    this.comicEliminado = this.listaComics[3].nombre;
    this.listaComics.splice(3,1);
    this.hola = JSON.stringify(this.listaComics);
    console.log(this.listaComics.length);
    console.log("hey");
  }

  public actVariable() : void{
}
}
