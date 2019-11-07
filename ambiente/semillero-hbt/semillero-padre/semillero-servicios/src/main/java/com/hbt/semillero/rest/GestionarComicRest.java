/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author 57314
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	@GET //tipo de envio
	@Path("/saludo") // ruta de acceso publica
	@Produces //define el tipo de recurso que se va a producir
	public String primerRest() {
		return "Hola mundo";
	}
	
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}	
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
