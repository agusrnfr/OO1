package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlazoFijoTest {
	
	private PlazoFijo plazoFijo;

	@BeforeEach
	void setUp() throws Exception {
		LocalDate fecha = LocalDate.now().minus(10,ChronoUnit.DAYS);
		plazoFijo = new PlazoFijo(fecha,100, 0.05); //pone 10 dias antes de la fecha actual
	}

	@Test
	void testConstructor() {
		assertEquals(LocalDate.now().minus(10,ChronoUnit.DAYS) , plazoFijo.getFechaDeConstitucion());
		assertEquals(100, plazoFijo.getMontoDepositado());
		assertEquals(0.05,plazoFijo.getPorcentajeDeInteresDiario());
	}
	
	void testValorActual() {
		assertEquals(150,plazoFijo.valorActual());
	}


}
