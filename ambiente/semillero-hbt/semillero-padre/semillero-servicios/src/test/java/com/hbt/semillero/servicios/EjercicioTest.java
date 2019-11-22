package com.hbt.semillero.servicios;

import org.testng.Assert;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.hbt.semillero.pojo.GestionarComicPOJO;
import com.hbt.semillero.pojo.Ejercicio;

public class EjercicioTest {

	Ejercicio ejerc = new Ejercicio();

	@Test(enabled = false)
	public void ejercicio3() {
		// Validacion de los diferentes casos
		Assert.assertTrue(ejerc.esPrimo(5) && ejerc.esPrimo(7) && ejerc.esPrimo(3));
	}

	@Test(enabled = false)
	public void ejercicio4() {

		// se inicializa la variable a comparar
		LocalDate date = LocalDate.parse("1998-10-30");
		// Validacion de la suma
		Assert.assertTrue(ejerc.sumaFechas(date, 21));
	}

}












