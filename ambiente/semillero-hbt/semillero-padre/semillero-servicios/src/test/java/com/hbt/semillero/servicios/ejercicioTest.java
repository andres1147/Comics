package com.hbt.semillero.servicios;

import org.testng.Assert;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.ejercicio;

public class ejercicioTest {
		
	@Test
	    private static boolean esPrimo(int numero){
	        int cont = 2;
	        boolean primo=true;
	        while ((primo) && (cont!=numero)){
	          if (numero % cont == 0)
	            primo = false;
	          cont++;
	        }
	        return primo;
	      }
	    
	
	@Test
	public void ejercicio3() {
		
		//Validacion de los diferentes casos
		Assert.assertTrue(esPrimo(5) && esPrimo(222)  && esPrimo(0));
		
	}
	  
		
	
}












