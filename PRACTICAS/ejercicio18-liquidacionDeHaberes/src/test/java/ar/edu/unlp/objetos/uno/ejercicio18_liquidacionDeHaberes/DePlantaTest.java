package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DePlantaTest {
	
	private DePlanta conHijos;
	private DePlanta conConyugue;
	private DePlanta sinNada;
	private DePlanta losTres;

	@BeforeEach
	void setUp() throws Exception {
		this.conHijos = new DePlanta (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true), LocalDate.of(2022, 10, 24), 100, 100, 100);
		this.conConyugue = new DePlanta (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),true, false), LocalDate.of(2022, 10, 24), 100, 100, 100);
		this.sinNada = new DePlanta (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, false), LocalDate.of(2022, 10, 24), 100, 100, 100);
		this.losTres = new DePlanta (new Empleado ("Jose","Diaz","123",LocalDate.of(2002, 10, 24),true, true), LocalDate.of(2022, 10, 24), 100, 100, 100);
	}

	@Test
	void testEstaVencido() {
		assertFalse(this.conHijos.estaVencido());
		assertFalse(this.conConyugue.estaVencido());
		assertFalse(this.sinNada.estaVencido());
		assertFalse(this.losTres.estaVencido());
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(200,this.conHijos.calcularMonto());
		assertEquals(200,this.conConyugue.calcularMonto());;
		assertEquals(100,this.sinNada.calcularMonto());
		assertEquals(300,this.losTres.calcularMonto());
	}

}
