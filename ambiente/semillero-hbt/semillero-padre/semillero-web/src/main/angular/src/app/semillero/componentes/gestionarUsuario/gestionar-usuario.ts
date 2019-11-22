
import { UsuarioDTO } from '../../dto/usuario.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

/**
 * @description Componente gestionar usuario, el cual contiene la logica CRUD de la clase Usuario
 * 
 * @author 57314
 */
@Component({
    selector: 'gestionar-usuario',
    templateUrl: './gestionar-usuario.html'
})
export class GestionarUsuarioComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarUsuarioForm: FormGroup;

    /**
     * Atributo que contendra la informacion del usuario
     */
    public usuario1: UsuarioDTO;
    public usuario: UsuarioDTO;

    public titulo: String;

    public mostrarEditarConsultar: boolean;

    /**
     * Atributo que contendra la lista de Usuarios creados
     */
    public listaUsuarios: Array<UsuarioDTO>;

    public idUsuario: number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * @description Este es el constructor del componente GestionarUsuarioComponent
     * @author 57314
     */
    constructor(private fb: FormBuilder,
        private router: Router) {
        this.gestionarUsuarioForm = this.fb.group({
            idPersona: [null, Validators.required],
            id: [null],
            nombre: [null],
            fechaCreacion: [null],
            estado: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author 57314
     * 
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.usuario1 = new UsuarioDTO();
        this.usuario = new UsuarioDTO();
        this.listaUsuarios = new Array<UsuarioDTO>();

        this.titulo = "Gestionar usuario";

        this.usuario.id = "1";
        this.usuario.nombre = "A8hlksn";
        this.usuario.fechaCreacion = new Date(12-12-2018);
        this.usuario.estadoUsuario = "ACTIVO";
        this.usuario.idPersona = "45";

        this.usuario1.id = "2";
        this.usuario1.nombre = "D5aldke";
        this.usuario1.fechaCreacion = new Date(2-2-2019);
        this.usuario1.estadoUsuario = "ACTIVO";
        this.usuario1.idPersona = "47";

        this.listaUsuarios.push(this.usuario);
        this.listaUsuarios.push(this.usuario1);
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un usuario
     */
    public crearActualizarUsuario(): void {
        this.submitted = true;
        if (this.gestionarUsuarioForm.invalid) {
            return;
        }
        this.usuario  = new UsuarioDTO();
        this.usuario.fechaCreacion = this.f.fechaCreacion.value;
        this.usuario.idPersona = this.f.idPersona.value;
        this.listaUsuarios.push(this.usuario);
        this.limpiarFormulario();
    }

    /**
     * Metodo que permite consultar un usuario de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del usuario seleccionado
     */
    public consultarUsuario(posicion: number): void {
        let usuario = this.listaUsuarios[posicion];
        this.titulo = "Consultar usuario";
        this.mostrarEditarConsultar = true;
        this.f.id.setValue(usuario.id);
        this.f.nombre.setValue(usuario.nombre);
        this.f.fechaCreacion.setValue(usuario.fechaCreacion);
        this.f.idPersona.setValue(usuario.idPersona);
        this.f.estado.setValue(usuario.estadoUsuario);
        this.f.nombre.disable();
        this.f.id.disable();
        this.f.fechaCreacion.disable();
        this.f.idPersona.disable();
        this.f.estado.disable();
    }

    /**
     * Metodo que permite consultar un usuario de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del usuario seleccionado
     */
    public editarUsuario(posicion: number): void {
        let usuario = this.listaUsuarios[posicion];
        this.mostrarEditarConsultar = true;
        this.f.id.setValue(usuario.id);
        this.f.nombre.setValue(usuario.nombre);
        this.f.fechaCreacion.setValue(usuario.fechaCreacion);
        this.f.idPersona.setValue(usuario.idPersona);
        this.f.estado.setValue(usuario.estado);
        this.f.nombre.enable();
        this.f.id.disable();
        this.f.fechaCreacion.disable();
        this.f.idPersona.disable();
        this.f.estado.disable();
    }
    
    /**Entregada la posicion fisica real, puede inactivar
     * un usuario de la lista
     */
    public inactivarUsuario(posicion: number): void {
        this.listaUsuarios[posicion].estado = "INACTIVO";
    }

    /**Metodo utilizado para limpiar todos los campos
     * del formulario reactivo
     */
    private limpiarFormulario(): void {
        this.submitted = false;
        this.f.fechaCreacion.setValue(null);
        this.f.idPersona.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author 57314
     */
    get f() {
        return this.gestionarUsuarioForm.controls;
    }
} 