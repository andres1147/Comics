/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author 57314
 * @version
 */
public class ejercicio{
	
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
	    

}
