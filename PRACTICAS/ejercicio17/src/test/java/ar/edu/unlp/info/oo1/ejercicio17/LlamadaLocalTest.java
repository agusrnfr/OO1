package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaLocalTest {
	
	private LlamadaLocal llamada;

	@BeforeEach
	void setUp() throws Exception {
		this.llamada = new LlamadaLocal("221234234", "221321321",LocalDateTime.of(2022, 10, 6, 16, 31), 10);
	}

	@Test
	void test() {
		assertEquals(10,llamada.calcularCosto());
	}

}
