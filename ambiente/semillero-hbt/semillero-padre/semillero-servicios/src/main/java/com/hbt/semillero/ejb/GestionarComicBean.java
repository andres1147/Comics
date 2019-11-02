/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author 57314
 * @version 
 */

@Stateless
public class GestionarComicBean {
	
	@PersistenceContext
	private EntityManager em;
	
	//TODO
	/**Agregar interfaz
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		
		/**TODO
		 * 
		 * Llenar con los demás datos
		 */
		
		em.persist(comic);	
		
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());

		em.merge(comic);	
		
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, id);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		return comicDTO;

	}
	
	public List<Comic> consultarTodos(){
		em.createNativeQuery("SELECT c from Comic").getResultList();
		List<Comic> resultados = (List<Comic>) em.createQuery("SELECT c from Comic").getResultList();
	return resultados;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
