
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    public titulo: String;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    public consultar : boolean;
    public mostrarId : boolean;
    public mostrarEliminar : boolean;
    public idMostrar : String;



    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router) {
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        
        this.titulo = "Gestionar Comic";
        this.consultar = false;
        this.mostrarId = false;
        this.mostrarEliminar = false;
        this.comic.id= "1"
        this.comic.nombre = "Andres";
        this.comic.editorial = "Marvel";
        this.comic.tematica = "Horror";
        this.comic.precio = 22000;
        this.listaComics.push(this.comic);
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic() : void {
        this.submitted = true;
        if(this.gestionarComicForm.invalid) {
            return;
        }

        this.idComic++;
        this.comic = new ComicDTO();
        this.comic.id = this.idComic + "";
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.listaComics.push(this.comic);
        this.limpiarFormulario();
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.titulo = "Consultar Comic";
        this.consultar = true;
        this.mostrarId = true;
        this.idMostrar = comic.id;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public editarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.mostrarId = true;
        this.idMostrar = comic.id;
        //this.f.idComic.setValue(comic.id);
        this.f.nombre.setValue(comic.nombre);
        this.f.editorial.setValue(comic.editorial);
        this.f.tematica.setValue(comic.tematica);
        this.f.coleccion.setValue(comic.coleccion);
        this.f.numeroPaginas.setValue(comic.numeroPaginas);
        this.f.precio.setValue(comic.precio);
        this.f.autores.setValue(comic.autores);
        this.f.color.setValue(comic.color);
        //this.f.idComic.disable();
        this.f.nombre.enable();
        this.f.editorial.enable();
        this.f.tematica.enable();
        this.f.coleccion.enable();
        this.f.numeroPaginas.enable();
        this.f.precio.enable();
        this.f.autores.enable();
        this.f.color.enable();
    }
/**
    public editarComic(comic : any) : void {
        this.router.navigate(['bienvenida',comic]);
    } */

    /**limpia el Formulario */
    public cancelar() :void{
        this.limpiarFormulario();
        this.mostrarEliminar = false;
    }

    /**Regresa al componente gestionar */
    public regresarGestionar() :void{
        this.titulo = "Gestionar Comic";
        this.consultar = false;
        this.mostrarId = false;
        this.limpiarFormulario();
    }

    /**Entregada la posicion fisica real, puede eliminar
     * un elemento de la lista
     */
    public eliminarComic(posicion : number) : void{
        this.listaComics.splice(posicion,1);
        this.mostrarEliminar = true;
        this.limpiarFormulario();
      }

 /**Metodo utilizado para limpiar todos los campos
  * del formulario reactivo
  */
    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Andres Garces
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
} 