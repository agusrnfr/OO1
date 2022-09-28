package ar.edu.unlp.info.oo1.ejercicio12_solidos;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CilindroTest {
	Cilindro cilindro;

	@BeforeEach
	void setUp() throws Exception {
		this.cilindro = new Cilindro("Hierro", "Rojo", 2,2);
	}
	

	@Test
	void testGetVolumen() {
		assertEquals(25,Math.round(this.cilindro.getVolumen()));
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(50,Math.round(this.cilindro.getSuperficie()));
	}

}
