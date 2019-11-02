/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author 57314
 * @version
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematicaEnum, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoEnum estadoEnum, Long cantidad) {
		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, 
				tematicaEnum,
				coleccion, numeroPaginas, precio, autores, 
				color, fechaVenta,
				estadoEnum, cantidad);
		return comicDTO;
		
	}
	/*
	public ComicDTO crearComicDTO(ComicDTO comicDTO) {
		return comicDTO;
	}*/
	
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();

		}
		listaComics.add(comicDTO);
	}

	// TODO continuar llenando el COmicDTO para la sesion del Jueves
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();

		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();

		}

		listaComics.add(comicDTO);

	}
	
	
	public void modificarComicDTO(String id, String nombre) {
		
		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicAModificar = listaComics.get(i);
			if(comicAModificar.getId().equals(id)) {
				comicAModificar.setNombre(nombre);
				return;
			}
			
		}
	}
	
	
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
		
	}
	
	public void eliminarComicDTO(List<ComicDTO> listaComics, String id) {
		Iterator<ComicDTO> it = listaComics.iterator();
		int cont = 0;
	
		while(it.hasNext() && listaComics.get(cont).getId() == "1") {
			listaComics.remove(cont);
			cont++;
		}
	}
	
	public static void removeBands(Collection<String> bands,
            Collection<String> undesirableBands){
Iterator<String> iteratorBand = bands.iterator();

while(iteratorBand.hasNext()){
if(undesirableBands.contains(iteratorBand.next())){
iteratorBand.remove();
}
}
}
	

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
