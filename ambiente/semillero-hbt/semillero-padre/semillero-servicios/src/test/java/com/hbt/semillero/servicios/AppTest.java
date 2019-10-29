package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	
	@Test
	public void primeraPU() {
		Long resultadoEsperado=150L;
		Long sumando1=100L;
		Long sumando2=50L;
		Long resultado=sumando1+sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);	
	}

	@Test
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
	
}












