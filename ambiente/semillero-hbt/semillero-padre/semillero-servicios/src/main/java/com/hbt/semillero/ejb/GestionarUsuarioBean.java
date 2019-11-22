package com.hbt.semillero.ejb;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.EstadoUsuarioEnum;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Usuario;

/**
 * @author 57314
 * 
 * Se utilizara para empezar la comunicacion entre
 *  la base de datos y la aplicacion
 *  
 *  Ademas, debe tener estado(stateful)
 */

@Stateful
public class GestionarUsuarioBean implements IGestionarUsuarioLocal {

	@PersistenceContext
	private EntityManager em;
	/*
	 * para que funcione bien necesitamos que entre un usuarioDTO debe guardar
	 * informacion en la base de datos REQUIRES_NEW pregunta si hay una transaccion
	 * activa, entonces crea una nueva y si no tiene una transaccion entonces crea
	 * una nueva
	 */

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = condicionarCrear(usuarioDTO);
		em.persist(usuario);
	}

	private Usuario condicionarCrear (UsuarioDTO usuarioDTO ) {
		//String nombreGenerado = autogenerarnombreUsuario();
		//private Usuario convertirUsuarioDTOtoUsuario(UsuarioDTO usuarioDTO) {
			Usuario usuario = new Usuario();
			if (usuarioDTO.getId() != null) {
				usuario.setId(Long.parseLong(usuarioDTO.getId()));
			}
			usuario.setNombre(validarNombreGenerado());
			usuario.setFechaCreacion(confirmarFecha(usuarioDTO.getFechaCreacion()));
			usuario.setIdpersona(validarExistenciaPersona(usuarioDTO.getIdpersona()));
			
			return usuario;
		
	}
	

	/*Validacion de usuarios repetidos con el mismo nombre que me autogenero el random de java.util
	 * Retorna true cuando se encuentra repetido
	 * */
	private boolean validarRepetidos(String nombre) {
		if (em.createNativeQuery("select u from u where sunombre='nombre'").getResultList() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Metodo que autogenera el nombre de Usuario con las condiciones de que 
	 * que el nombre no debe ser mayor de 7 caracteres el cual el primero debe 
	 * ser una letra en mayúsculas, el segundo un numero de 0 a 9 y los restantes solo pueden ser letras en minúsculas.
	 * */
	private String autogenerarnombreUsuario() {
		String generate = "";
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			if (i < 1) {
				generate += random.nextInt(10);
			} else if (i < 2) {
				generate += (char) (random.nextInt(91) + 65);
			} else {
				generate += (char) (random.nextInt(123) + 97);
			}
		}
		return generate;
	}
	
	
	/**
	 * Autogenera nombres de Usuarios y luego corrobora que no existan
	 * Hace uso de dos metodos alternos
	 * */
	private String validarNombreGenerado() {
		String generate = "";
	    do {
	    	generate = autogenerarnombreUsuario();
	    }while (!validarRepetidos(generate));
		return generate;
	}

	/*Verifica la Expiracion del usuario, 
	 * añadiendo un año a la fecha de creacion del mismo y comparandolo con la fecha actual
	 * 
	 * */
	private boolean verificarExpiracion(LocalDate fechaCreacion) {

		if ((fechaCreacion.plusYears(1).equals(LocalDate.now()))
				|| (fechaCreacion.plusYears(1).isAfter(LocalDate.now()))) {
			return true;
		} else {
			return false;
		}
	}

	/*En la creacion de un nuevo usuario, este metodo ayudara a 
	 * verificar que se ingresen fechas validas(no puede ser mayor a la fecha actual)
	 * */
	private boolean validarFecha(LocalDate fechaCreacion) {
		boolean validacion = fechaCreacion.isBefore(LocalDate.now());
		return validacion;
	}
	
	
	/*Verifica que si exista una persona con ese id entregado 
	 * */
	private Persona validarExistenciaPersona(Persona persona) {
	    Long idPersona = persona.getId();
		if (em.createNativeQuery("select p from p where spid = idPersona").getResultList() != null) {
			return persona;
		} else {
			return null;
		}
	}
	
	/**
	 * confirma que el atributo fechaCreacion ingresado como atributo de la clase Usuario
	 * cumpla con las condiciones del caso
	 * */
	private LocalDate confirmarFecha(LocalDate fechaCreacion) {
		if(validarFecha(fechaCreacion)) {
			return fechaCreacion;
		}
		return null;
	}
	
	
	

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void modificarUsuario(UsuarioDTO usuarioModificar) {
		Usuario usuario = new Usuario();
		// usuario.setId(usuarioModificar.getId());
		em.merge(usuario);
	}

	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(String id) {
		Usuario usuario = em.find(Usuario.class, id);
		UsuarioDTO usuarioDTO = convertirUsuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarTodos() {
		em.createNativeQuery("SELECT c FROM Usuario").getResultList();
		List<Usuario> resultados = (List<Usuario>) em.createQuery("select c from Usuario").getResultList();
		return null;
	}

	/**
	 * Permitir modificar el nombre de un Usuario dado esto por medio de el id
	 */
	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// TODO Cual es el resultado si no se aplica la transaccion pero si la necesita
	public void modificarUsuario(Long id, String nombre, UsuarioDTO usuarioNuevo) {
		Usuario usuarioModificar;
		if (usuarioNuevo == null) { // no llego el dto con toda la informacion del usuario entonces toca buscarlo
			usuarioModificar = em.find(Usuario.class, id);// select * from usuario, es lo que realiza por debajo
		} else { // si el usuario nuevo llega, se necesita transformar la informacion
			usuarioModificar = convertirUsuarioDTOtoUsuario(usuarioNuevo);
		} // TODO Hacer la validacion si el usuario a modificar llego con datos
		usuarioModificar.setNombre(nombre);
		// si encuentra en la bd actualiza, sino inserta
		em.merge(usuarioModificar);
	}

	// Metodo para cambiar el estado de un Usuario
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void cambiarEstadoUsuario(Long idUsuario) {

		// Encuentra el usuario en la lista
		Usuario usuario = em.find(Usuario.class, idUsuario);

		// Valida la existencia de un usuario con ese mismo id entregado
		if (usuario != null) {

			usuario.setEstadoUsuarioEnum(EstadoUsuarioEnum.INACTIVO);
			
			// Comienza una nueva transaccion
			em.getTransaction().begin();
			
			//Realiza la modificacion del usuario
			em.merge(usuario);

			/**
			 * Confirma la transaccion para cambiar el estado del usuario con el id coincidente. Si
			 * no se hace este paso, se revierte la transaccion y no se cambia el estado del Usuario
			 */
			em.getTransaction().commit();
		} else {
			return;
		}
	}

	//Se inserta una consulta dentro del metodo para realizar la operacion de consultar todos los Usuarios de la DB
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>(); // conjunto de elementos que almacena datos con cierto orden
		List<Usuario> resultados = em.createQuery("select u from Usuario u").getResultList();// u hace referencia a toda la entidad
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}
		return resultadosUsuarioDTO;
	}

	/**
	 * Metodo encargado para transpasar informacion de un lado a otro, no incluye
	 * manipulacion de datos SOLO los metodos (em) son los que necesitan
	 * transaccionalidad
	 */
	private Usuario convertirUsuarioDTOtoUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getId() != null) {
			usuario.setId(Long.parseLong(usuarioDTO.getId()));
		}
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setEstadoUsuarioEnum(usuarioDTO.getEstadoUsuarioEnum());
		usuario.setIdpersona(usuarioDTO.getIdpersona());

		return usuario;
	}

	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getId() != null) {
			usuarioDTO.setId(usuario.getId().toString());
		}
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setEstadoUsuarioEnum(usuario.getEstadoUsuarioEnum());
		usuarioDTO.setIdpersona(usuario.getIdpersona());

		return usuarioDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#eliminarUsuario(java.lang.Long)
	 */
	@Override
	public void eliminarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
