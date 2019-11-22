package com.hbt.semillero.ejb;

import java.util.List;
import javax.ejb.Local;
import com.hbt.semillero.dto.UsuarioDTO;

/**
 * Expone los métodos del EJB GestionarUsuario Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author 57314
 *
 */
@Local
public interface IGestionarUsuarioLocal {

	/**
	 * 
	 * Metodo encargado de crear un usuario y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param usuarioNuevo informacion nueva a crear
	 */
	public void crearUsuario(UsuarioDTO usuarioNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un usuario modificarlo y guardarlo
	 * 
	 * @author 57314
	 * 
	 * @param usuarioModificar informacion nueva a modificar
	 */
	public void modificarUsuario(Long id, String nombre, UsuarioDTO usuarioNuevo);

	/**
	 * 
	 * Metodo encargado de eliminar un usuario modificarlo y guardarlo
	 * 
	 * @author 57314
	 * 
	 * @param usuarioEliminar informacion a eliminar
	 */
	public void eliminarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un usuario
	 * 
	 * @param idComic identificador del usuario a ser consultado
	 * @return usuario Resultado de la consulta
	 * @throws Exception si no se recibe idUsuario
	 */
	public UsuarioDTO consultarUsuario(String idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar una lista de usuarios
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
}
