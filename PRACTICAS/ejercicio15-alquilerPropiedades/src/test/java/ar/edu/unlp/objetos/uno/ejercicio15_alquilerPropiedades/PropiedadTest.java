package ar.edu.unlp.objetos.uno.ejercicio15_alquilerPropiedades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Usuario propietario1;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario1 = new Usuario ("SoyPropietario1", "ABC", "123");
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		this.propiedad1 = new Propiedad ("Propiedad1", "abc" , "Avenida Siempre Viva 742", 500, propietario1);
		this.propiedad2 = new Propiedad ("Propiedad2", "bca" , "Avenida San Martin 421", 200, propietario1);
		this.reserva1 = new Reserva (this.lapso, this.propiedad1);
		this.reserva2 = new Reserva (this.lapso2, this.propiedad2);
		this.reserva3 = new Reserva (this.lapso3,this.propiedad2);
		this.propietario1.agregarPropiedad(propiedad1);
		this.propietario1.agregarPropiedad(propiedad2);
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad2.agregarReserva(reserva2);
		this.propiedad2.agregarReserva(reserva3);
	}

	@Test
	void testDisponibilidad() {
		assertFalse(this.propiedad1.disponibilidad(lapso));
		assertTrue(this.propiedad1.disponibilidad(lapso3));
	}
	
	@Test
	void testCalcularIngresoPropiedad() {
		assertEquals(5000,this.propiedad1.calcularIngresoPropiedad(new DateLapse (LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15))));
		assertEquals(3800,this.propiedad2.calcularIngresoPropiedad(new DateLapse (LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15))));
		assertEquals(0,this.propiedad1.calcularIngresoPropiedad(new DateLapse (LocalDate.of(2022, 10, 15), LocalDate.of(2025, 11, 15))));
	}

}
