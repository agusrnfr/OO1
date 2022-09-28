package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EsferaTest {
	Esfera esfera;

	@BeforeEach
	void setUp() throws Exception {
		this.esfera = new Esfera ("Madera","Rojo",2);
	}

	@Test
	void testGetVolumen() {
		assertEquals(34,Math.round(this.esfera.getVolumen()));
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(50,Math.round(this.esfera.getSuperficie()));
	}

}
