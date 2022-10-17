package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private Usuario usuarioConReservas;
	private Usuario usuarioSinReservas;
	private Usuario propietario1;
	private Usuario propietarioSinPropiedades;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private DateLapse lapso;
	private DateLapse lapso2;
	private DateLapse lapso3;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private CancelacionFlexible politica;
	

	@BeforeEach
	void setUp() throws Exception {
		this.usuarioConReservas = new Usuario ("Lana", "Dir", "333");
		this.usuarioSinReservas = new Usuario ("Madonna", "Dir", "222");
		this.propietario1 = new Usuario ("SoyPropietario1", "ABC", "123");
		this.propietarioSinPropiedades = new Usuario ("SoyPropietario2", "ABC", "123");
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		this.propiedad1 = new Propiedad ("Propiedad1", "abc" , "Avenida Siempre Viva 742", 500, propietario1, politica );
		this.propiedad2 = new Propiedad ("Propiedad2", "bca" , "Avenida San Martin 421", 200, propietario1, politica);
		this.reserva1 = new Reserva (this.lapso, this.propiedad1);
		this.reserva2 = new Reserva (this.lapso2, this.propiedad2);
		this.reserva3 = new Reserva (this.lapso3,this.propiedad2);
		this.usuarioConReservas.agregarReserva(reserva1);
		this.usuarioConReservas.agregarReserva(reserva2);
		this.usuarioConReservas.agregarReserva(reserva3);
		this.propietario1.agregarPropiedad(propiedad1);
		this.propietario1.agregarPropiedad(propiedad2);
		this.propiedad1.agregarReserva(reserva1);
		this.propiedad2.agregarReserva(reserva2);
		this.propiedad2.agregarReserva(reserva3);
		
	}

	@Test
	void testAgregarReserva() {
		assertEquals(3, this.usuarioConReservas.getReservas().size());
		assertEquals(0,this.usuarioSinReservas.getReservas().size());
		
	}
	
	@Test
	void testEliminarReserva() {
		this.usuarioConReservas.eliminarReserva(reserva1);
		this.usuarioConReservas.eliminarReserva(reserva2);
		this.usuarioConReservas.eliminarReserva(reserva3);
		assertEquals(0,this.usuarioConReservas.getReservas().size());
		this.usuarioSinReservas.eliminarReserva(reserva1);
		assertEquals(0,this.usuarioSinReservas.getReservas().size());
		
	}
	
	@Test
	void testCalcularIngresoPropietario() {
		assertEquals(8800,this.propietario1.calcularIngresoPropietario(new DateLapse (LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15))));
		assertEquals(7800,this.propietario1.calcularIngresoPropietario(new DateLapse (LocalDate.of(2022, 10, 13), LocalDate.of(2025, 11, 15))));
		assertEquals(2800,this.propietario1.calcularIngresoPropietario(new DateLapse (LocalDate.of(2022, 10, 16), LocalDate.of(2025, 11, 15))));
		assertEquals(0,this.propietarioSinPropiedades.calcularIngresoPropietario(lapso));
		
	}

}
