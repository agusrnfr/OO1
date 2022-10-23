package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInterurbanaTest {
	
	private LlamadaInterurbana llamadaMenos100;
	private LlamadaInterurbana llamadaMenos500;
	private LlamadaInterurbana llamadaMas500;
	private LlamadaInterurbana exac100;
	private LlamadaInterurbana exac500;
	

	@BeforeEach
	void setUp() throws Exception {
		this.llamadaMenos100 = new LlamadaInterurbana ("221123123", "221123123", LocalDateTime.of(2022, 10, 23, 16, 55), 10, 99);
		this.llamadaMenos500 = new LlamadaInterurbana ("221123123", "221123123", LocalDateTime.of(2022, 10, 23, 16, 55), 10, 499);
		this.llamadaMas500 = new LlamadaInterurbana ("221123123", "221123123", LocalDateTime.of(2022, 10, 23, 16, 55), 10, 501);
		this.exac100 = new LlamadaInterurbana ("221123123", "221123123", LocalDateTime.of(2022, 10, 23, 16, 55), 10, 100);
		this.exac500 = new LlamadaInterurbana ("221123123", "221123123", LocalDateTime.of(2022, 10, 23, 16, 55), 10, 500);
	}

	@Test
	void test() {
		assertEquals(25,llamadaMenos100.calcularCosto());
		assertEquals(30,llamadaMenos500.calcularCosto());
		assertEquals(30,exac100.calcularCosto());
		assertEquals(30,exac500.calcularCosto());
		assertEquals(35,llamadaMas500.calcularCosto());
	}

}
