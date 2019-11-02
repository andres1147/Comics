package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	
	@Test(enabled=false)
	public void primeraPU() {
		Long resultadoEsperado=150L;
		Long sumando1=100L;
		Long sumando2=50L;
		Long resultado=sumando1+sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);	
	}

	@Test(enabled=false)
	private String invertirCadena(String cadena) {
		
		//Validación para que la longitud del dato de entrada sea mayor a 1
		 Assert.assertTrue(cadena.length()>1);
		
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);            
        }
        
        //Validación para que no sean del todo iguales
        Assert.assertNotEquals(cadena, cadenaInvertida);
        Assert.assertNotSame(cadena, cadenaInvertida);
        
        //Validación para que la longitud de la cadena y su inverso sea igual
        Assert.assertEquals(cadena.length(), cadenaInvertida.length());
        
        //Verificar que la última letra del dato cadena sea igual a la primera de cadenaInvertida y viceversa
        Assert.assertEquals(cadena.charAt(cadena.length()-1), cadenaInvertida.charAt(0));
        Assert.assertEquals(cadena.charAt(0), cadenaInvertida.charAt(cadenaInvertida.length()-1));
        
        return cadenaInvertida;
}
	
	
		//TODO
		/*
		 * Pendiente hacer un metodo que use el metodo TODO de la entidad Comic
		 */
	public void crearComic() {
		Comic comic1 = new Comic();
		
		comic1.setNombre("Iron Man");
		comic1.setEditorial("Marvel");
		comic1.setColeccion("Guerreros Galaxia");
		comic1.setNumeroPaginas(147);
		comic1.setPrecio(new BigDecimal(1500));
		comic1.setCantidad(5L);
	}
	
	
	@Test(enabled=false)
	public void manipularEstadoEnum() {
		EstadoEnum enum1 = EstadoEnum.ACTIVO;
		EstadoEnum enum2 = EstadoEnum.INACTIVO;
		enum1.setCodigoMensaje("1");
		
		//Compara un estatico con el metodo del enumerador que devuelve un String con el nombre de la constante (ACTIVO)
		Assert.assertEquals(enum1.name(), "ACTIVO");

		// Valida la posicion comparando un dato de entrada con la posición del enum según está declarada (0)
		Assert.assertEquals(enum1.ordinal(), 0);
		
		// Testea sobre la diferencia entre el parametro segun el orden de los dos enum declarados
		Assert.assertTrue(enum1.compareTo(enum2)<0);  
		
		String[] nuevoArray= new String[]{"ACTIVO", "INACTIVO"};
		
		// Compara el array creado con lo que devuelve el metodo enumerador
		Assert.assertEquals(EstadoEnum.values(),  nuevoArray);
	}
	
	
	//add
	@Test(enabled=false)
	public void crearComicDTOTest() {
		
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();	
		
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()!=0);
		//preferible usar el metodo de abajo
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}
	
	//add
	@Test(enabled=false)
	public void creartComicDTOTest() {
		
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", 
				"Capitan America", "Panini", TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128,
				new BigDecimal(5000), "Phillippe", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==1);
		//preferible usar el metodo de abajo
		
		comicDTO = new ComicDTO();
		
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(null);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(null);
		comicDTO.setCantidad(20L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()>1);
	}
	
}












