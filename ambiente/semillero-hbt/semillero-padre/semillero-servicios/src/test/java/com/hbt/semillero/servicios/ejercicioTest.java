package com.hbt.semillero.servicios;

import org.testng.Assert;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.GestionarComicPOJO;
import com.hbt.semillero.pojo.ejercicio;

public class ejercicioTest {
		
	ejercicio hola = new ejercicio();
	
	@Test
	public void ejercicio3() {
		
		//Validacion de los diferentes casos
		Assert.assertTrue(hola.esPrimo(5) && hola.esPrimo(222) && hola.esPrimo(0));
		
	}
	  
		
	
}












