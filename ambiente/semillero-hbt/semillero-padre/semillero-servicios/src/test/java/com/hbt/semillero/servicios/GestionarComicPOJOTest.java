package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

public class GestionarComicPOJOTest {
	
	
	@Test
	public void gestionarComicDTOTest() {
		
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		
		//Validación que confirma que la listaComics no tiene elementos
		Assert.assertNull(gestionarComicPOJO.getListaComics());
	
		ComicDTO comicDTO1 = new ComicDTO();
		
		comicDTO1.setId("1");
		comicDTO1.setNombre("Dragon Ball Yamcha");
		comicDTO1.setEditorial("Planeta Cómic");
		comicDTO1.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO1.setColeccion("Manga Shonen");
		comicDTO1.setNumeroPaginas(144);
		comicDTO1.setPrecio(new BigDecimal(2100));
		comicDTO1.setAutores("Dragon Garow Lee");
		comicDTO1.setColor(Boolean.TRUE);
		comicDTO1.setFechaVenta(LocalDate.now());
		comicDTO1.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO1.setCantidad(20L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO1);
		
		//Testea que se agregó correctamente el nuevo objeto
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==1);
	
		ComicDTO comicDTO2 = new ComicDTO();
		
		comicDTO2.setId("2");
		comicDTO2.setNombre("Captain America Corps 1-5 USA");
		comicDTO2.setEditorial("Panini Comics");
		comicDTO2.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO2.setColeccion("BIBLIOTECA MARVEL");
		comicDTO2.setNumeroPaginas(128);
		comicDTO2.setPrecio(new BigDecimal(5000));
		comicDTO2.setAutores("Phillippe Briones, Roger Stern");
		comicDTO2.setColor(Boolean.TRUE);
		comicDTO2.setFechaVenta(LocalDate.now());
		comicDTO2.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO2.setCantidad(5L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO2);
		
		ComicDTO comicDTO3 = new ComicDTO();
		
		comicDTO3.setId("3");
		comicDTO3.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO3.setEditorial("Panini Comics");
		comicDTO3.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO3.setColeccion("MARVEL COMICS");
		comicDTO3.setNumeroPaginas(208);
		comicDTO3.setPrecio(new BigDecimal(6225));
		comicDTO3.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO3.setColor(Boolean.FALSE);
		comicDTO3.setFechaVenta(LocalDate.now());
		comicDTO3.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO3.setCantidad(0L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO3);
		
		//Validación de la cantidad de objetos ingresados
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==3);
		
		//Llamada al método que modifica el objeto segun posición, solo aplica para modificar atributo nombre
		gestionarComicPOJO.modificarComicDTO("1", "America");
		
		//Validación para verificar que fue efectiva la modificacion
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(0).getNombre(), "America");
		
		//Testear que solo se hizo la modificación a la posición de objeto indicado en el método
		Assert.assertNotEquals(gestionarComicPOJO.getListaComics().get(1).getNombre(), "America");
		Assert.assertNotEquals(gestionarComicPOJO.getListaComics().get(2).getNombre(), "America");
		
		//Verificar que el tamaño no se modifico
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==3);
		
		//Llamada al método que elimina de la listaComics según atributo id
		gestionarComicPOJO.eliminarComicDTO(gestionarComicPOJO.getListaComics(), "1");
		
		//Validación de que no se hayan eliminado todos los objetos
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		
		//Validación de que el tamaño de la lista sea uno menos comparado con el valor de antes de ejecutarse el método
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==2);
		
	}
	
	
}












