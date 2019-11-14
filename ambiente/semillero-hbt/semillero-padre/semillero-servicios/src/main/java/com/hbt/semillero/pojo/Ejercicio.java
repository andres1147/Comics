/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author 57314
 * @version
 */
public class Ejercicio{
	
	  public boolean esPrimo(int numero){
	        int cont = 2;
	        boolean primo=true;
	        while ((primo) && (cont!=numero)){
	          if (numero % cont == 0)
	            primo = false;
	          cont++;
	        }
	        return primo;
	      }
	  
	  public boolean sumaFechas(LocalDate fechaNacimiento, int edad) {
		  
		  //condicion de suma de año y edad
		 if( fechaNacimiento.getYear() + edad == 2019) {
			 return true;
			 
		 }
		return false;
		  
	  }
	    

}
