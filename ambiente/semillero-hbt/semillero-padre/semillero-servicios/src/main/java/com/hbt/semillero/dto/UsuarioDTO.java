package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.hbt.semillero.entidades.EstadoUsuarioEnum;
import com.hbt.semillero.entidades.Persona;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author 57314
 * @version
 */

public class UsuarioDTO implements Serializable {
	
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -5399548644245498958L;
	
	private String id;
    private String nombre;
    private LocalDate fechaCreacion;
    private EstadoUsuarioEnum estadoUsuarioEnum;
    private Persona idpersona;

	/**
	 * Constructor de la clase.
	 */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estadoUsuarioEnum
	 * @param idpersona
	 */
	public UsuarioDTO(String id, String nombre, LocalDate fechaCreacion, EstadoUsuarioEnum estadoUsuarioEnum,
			Persona idpersona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estadoUsuarioEnum = estadoUsuarioEnum;
		this.idpersona = idpersona;
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 */
	public UsuarioDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoUsuarioEnum
	 * @return El estadoUsuarioEnum asociado a la clase
	 */
	@Enumerated(value = EnumType.STRING)
	public EstadoUsuarioEnum getEstadoUsuarioEnum() {
		return estadoUsuarioEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoUsuarioEnum
	 * @param estadoUsuarioEnum El nuevo estadoUsuarioEnum a modificar.
	 */
	public void setEstadoUsuarioEnum(EstadoUsuarioEnum estadoUsuarioEnum) {
		this.estadoUsuarioEnum = estadoUsuarioEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo idpersona
	 * @return El idpersona asociado a la clase
	 */
	public Persona getIdpersona() {
		return idpersona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idpersona
	 * @param idpersona El nuevo idpersona a modificar.
	 */
	public void setIdpersona(Persona idpersona) {
		this.idpersona = idpersona;
	}


}












