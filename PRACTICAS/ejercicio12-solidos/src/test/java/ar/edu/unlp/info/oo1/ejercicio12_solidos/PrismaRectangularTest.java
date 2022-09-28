package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrismaRectangularTest {
	
	PrismaRectangular prisma;

	@BeforeEach
	void setUp() throws Exception {
		this.prisma = new PrismaRectangular ("Hierro", "Rojo",2,2,2);
	}

	@Test
	void testGetVolumen() {
		assertEquals(8,this.prisma.getVolumen());
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(24,this.prisma.getSuperficie());
	}

}
