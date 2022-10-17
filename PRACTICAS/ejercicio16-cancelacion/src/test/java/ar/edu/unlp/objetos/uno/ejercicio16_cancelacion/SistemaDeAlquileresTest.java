package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaDeAlquileresTest {
	
	private SistemaDeAlquileres sistema;
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
		this.sistema = new SistemaDeAlquileres();
		
		this.usuarioConReservas = this.sistema.registrarUsuario("Lana", "Dir", "333");
		this.usuarioSinReservas = this.sistema.registrarUsuario("Madonna", "Dir", "222");
		this.propietario1 = this.sistema.registrarUsuario("SoyPropietario1", "ABC", "123");
		this.propietarioSinPropiedades = this.sistema.registrarUsuario("SoyPropietario2", "ABC", "123");
		this.propiedad1 = this.sistema.registrarPropiedad("Propiedad1", "abc" , "Avenida Siempre Viva 742", 500, propietario1, politica);
		this.propiedad2 = this.sistema.registrarPropiedad("Propiedad2", "bca" , "Avenida San Martin 421", 200, propietario1, politica);
		
		this.propietario1.agregarPropiedad(propiedad1);
		this.propietario1.agregarPropiedad(propiedad2);
		
		this.lapso = new DateLapse (LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 15));
		this.lapso2 = new DateLapse (LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 6));
		this.lapso3 = new DateLapse (LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 15));
		
		this.reserva1 = new Reserva (this.lapso, this.propiedad1);
		this.reserva2 = new Reserva (this.lapso2, this.propiedad2);
		this.reserva3 = new Reserva (this.lapso3,this.propiedad2);
		
	}

	@Test
	void testListarPropiedadesDisponibles() {
		assertEquals(2,this.sistema.listarPropiedadesDisponibles(lapso).size());
		this.propiedad1.agregarReserva(reserva1);
		assertEquals(1,this.sistema.listarPropiedadesDisponibles(lapso).size());
	}
	
	@Test 
	void testRealizarReserva() {
		assertNotNull(this.sistema.realizarReserva(propiedad1, lapso, usuarioConReservas));
		assertNull(this.sistema.realizarReserva(propiedad1, lapso, usuarioConReservas));
		assertNotNull(this.sistema.realizarReserva(propiedad1, lapso3, usuarioConReservas));
	}
	
	@Test
	void testEliminarReserva() {
		this.reserva1 = this.sistema.realizarReserva(propiedad1, lapso, usuarioConReservas);
		this.reserva2 = this.sistema.realizarReserva(propiedad2, lapso2, usuarioConReservas);
		this.reserva3 = this.sistema.realizarReserva(propiedad2, lapso3, usuarioConReservas);
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso).size());
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso2).size());
		assertEquals(1,this.sistema.listarPropiedadesDisponibles(lapso3).size());
		this.sistema.eliminarReserva(reserva1);
		this.sistema.eliminarReserva(reserva2);
		this.sistema.eliminarReserva(reserva3);
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso).size());
		assertEquals(0,this.sistema.listarPropiedadesDisponibles(lapso2).size());
		assertEquals(2,this.sistema.listarPropiedadesDisponibles(lapso3).size());
	}

	@Test
	void testObtenerReservaUsuario() {
		this.reserva1 = this.sistema.realizarReserva(propiedad1, lapso, usuarioConReservas);
		assertEquals(1,this.sistema.obtenerReservaUsuario(usuarioConReservas).size());
		assertEquals(0,this.sistema.obtenerReservaUsuario(usuarioSinReservas).size());
		
	}
	
	@Test
	void testCalcularIngresosPropietario() {
		this.reserva1 = this.sistema.realizarReserva(propiedad1, lapso, usuarioConReservas);
		this.reserva2 = this.sistema.realizarReserva(propiedad2, lapso2, usuarioConReservas);
		this.reserva3 = this.sistema.realizarReserva(propiedad2, lapso3, usuarioConReservas);
		assertEquals(8800,this.sistema.calcularIngresoPropietario(this.propietario1, new DateLapse (LocalDate.of(2022, 9, 30), LocalDate.of(2025, 11, 15))));
		assertEquals(7800,this.sistema.calcularIngresoPropietario(this.propietario1, new DateLapse (LocalDate.of(2022, 10, 13), LocalDate.of(2025, 11, 15))));
		assertEquals(2800,this.sistema.calcularIngresoPropietario(this.propietario1, new DateLapse (LocalDate.of(2022, 10, 16), LocalDate.of(2025, 11, 15))));
		assertEquals(0,this.sistema.calcularIngresoPropietario(this.propietarioSinPropiedades, lapso));
		
	}
}
