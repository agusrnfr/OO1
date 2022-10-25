package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PorHorasTest {
	
	private PorHoras vencido;
	private PorHoras noVencido;
	

	@BeforeEach
	void setUp() throws Exception {
		this.vencido = new PorHoras (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true), LocalDate.of(2015, 9, 20), LocalDate.of(2022, 10, 23), 100, 100);
		this.noVencido = new PorHoras (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true), LocalDate.of(2015, 9, 20), LocalDate.of(2023, 10, 23), 100, 100);
	}

	@Test
	void testEstaVencido() {
		assertTrue(this.vencido.estaVencido());
		assertFalse(this.noVencido.estaVencido());
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(10000,this.vencido.calcularMonto());
		assertEquals(10000,this.noVencido.calcularMonto());
	}

}
