/**
 * Usuario.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción: Clase que define un usuario, se encuentra asociada a la clase Persona
 * y es necesaria para cumplir con el caso de uso 
 * <b>Caso de Uso: Establecer un método para vender sus revistar gráficas
 * @author 57314
 * @version 
 */

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 6893168802085247312L;
	
	private Long id;
    private String nombre;
    private LocalDate fechaCreacion;
    private EstadoUsuarioEnum estadoUsuarioEnum;
    private Persona idpersona;
    
    
	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	
	@Id
	@Column(name="SUID")
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SUID_GENERATOR")
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
	@Column(name="SUNOMBRE")
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
	@Column(name="SUFECHA_CREACION")
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
	@Column(name="SUESTADO")
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
	@Column(name="SUIDPERSONA")
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


	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", estadoUsuarioEnum="
				+ estadoUsuarioEnum + ", idpersona=" + idpersona + "]";
	}


	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoUsuarioEnum == null) ? 0 : estadoUsuarioEnum.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idpersona == null) ? 0 : idpersona.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Usuario other = (Usuario) obj;
		if (estadoUsuarioEnum != other.estadoUsuarioEnum)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idpersona == null) {
			if (other.idpersona != null)
				return false;
		} else if (!idpersona.equals(other.idpersona))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	

}
