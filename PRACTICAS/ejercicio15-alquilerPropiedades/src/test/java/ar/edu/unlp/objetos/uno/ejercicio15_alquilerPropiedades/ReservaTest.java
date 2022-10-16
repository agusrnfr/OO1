package ar.edu.unlp.objetos.uno.ejercicio15_alquilerPropiedades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {

	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		this.lapso4 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 5));
		this.propiedad1 = new Propiedad ("Propiedad1", "abc" , "Avenida Siempre Viva 742", 500, new Usuario ("Lana", "Dir", "333"));
		this.propiedad2 = new Propiedad ("Propiedad2", "bca" , "Avenida San Martin 421", 0, new Usuario ("Madonna", "Dir", "222"));
		this.reserva1 = new Reserva (this.lapso, this.propiedad1);
		this.reserva2 = new Reserva (this.lapso2, this.propiedad2);
		this.reserva3 = new Reserva (this.lapso3,this.propiedad2);
	}

	@Test
	void testCalcularReserva() {
		assertEquals(5000, this.reserva1.calcularReserva());
		assertEquals(0, this.reserva2.calcularReserva());
	}
	
	@Test
	void testOverlaps() {
		assertTrue (this.reserva1.overlaps(lapso2));
		assertFalse (this.reserva1.overlaps(lapso4));
		assertTrue(this.reserva1.overlaps(lapso));
		
	}
	
	@Test
	void testLaterFrom() {
		assertTrue (this.reserva3.inicioPosteriorFechaActual());
		assertFalse (this.reserva1.inicioPosteriorFechaActual());
		
	}
	

}
