/**
 * GestionarUsuarioRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;

/**
 * <b>Descripción:<b> 
 * <b>Caso de Uso:<b> 
 * @author 57314
 * @version 
 */
@Path("/GestionarUsuario")
public class GestionarUsuarioRest {
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;
	
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario!=null) {
			return gestionarUsuarioEJB.consultarUsuario(idUsuario.toString());
		}	
		return null;
	}
	
}
