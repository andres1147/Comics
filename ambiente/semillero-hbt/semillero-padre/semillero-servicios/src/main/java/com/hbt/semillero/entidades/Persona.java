/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que sera contenida dentro de la clase Usuario
 * <b>Caso de Uso: Permitir la gestion de usuarios
 * @author 57314
 * @version 
 */

@Entity
@Table(name="PERSONA")
public class Persona implements Serializable{

	
	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ; mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = -4795148554276345267L;

	private Long id;
    private String nombre;
    private Long numeroIdentificacion;
    
    
    
    
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name="SPID")
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SPID_GENERATOR")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	
	@Column(name="SCNOMBRE")
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
	 * Metodo encargado de retornar el valor del atributo numeroIdentificacion
	 * @return El numeroIdentificacion asociado a la clase
	 */
	
	@Column(name="SCNUMIDENTIFICACION ")
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}





	/**
	 * Metodo encargado de modificar el valor del atributo numeroIdentificacion
	 * @param numeroIdentificacion El nuevo numeroIdentificacion a modificar.
	 */
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}





	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + "]";
	}

	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
		return result;
	}

	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroIdentificacion == null) {
			if (other.numeroIdentificacion != null)
				return false;
		} else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
			return false;
		return true;
	}
	
	
}
	
	
	
	