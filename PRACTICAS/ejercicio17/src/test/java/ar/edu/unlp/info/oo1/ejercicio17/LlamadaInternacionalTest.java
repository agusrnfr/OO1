package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInternacionalTest {
	
	private LlamadaInternacional menos20Hs;
	private LlamadaInternacional mas20Hs;
	private LlamadaInternacional menos8Hs;
	private LlamadaInternacional mas8Hs;


	@BeforeEach
	void setUp() throws Exception {
		this.mas20Hs = new LlamadaInternacional ("221123123", "221452235", LocalDateTime.of(2022, 10, 23, 20, 0), 10 , "Argentina", "Arabia Saudita");
		this.menos20Hs = new LlamadaInternacional ("221123123", "221452235", LocalDateTime.of(2022, 10, 23, 19, 59), 10 , "Argentina", "Arabia Saudita");
		this.menos8Hs = new LlamadaInternacional ("221123123", "221452235", LocalDateTime.of(2022, 10, 23, 7, 59), 10 , "Argentina", "Arabia Saudita");
		this.mas8Hs = new LlamadaInternacional ("221123123", "221452235", LocalDateTime.of(2022, 10, 23, 8, 0), 10 , "Argentina", "Arabia Saudita");
	}

	@Test
	void test() {
		assertEquals(40,menos20Hs.calcularCosto());
		assertEquals(40,mas8Hs.calcularCosto());
		assertEquals(30,mas20Hs.calcularCosto());
		assertEquals(30,menos8Hs.calcularCosto());
		
	}

}
