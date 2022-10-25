package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {
	
	private Empleado empleadoConContratoVencido;
	private Empleado empleadoSinContratoVencido;
	private Empleado empleado4Años;
	private Empleado empleado5Años;
	private Empleado empleado10Años;
	private Empleado empleado15Años;
	private Empleado empleado20Años;


	@BeforeEach
	void setUp() throws Exception {
		this.empleadoConContratoVencido = new Empleado("Jose","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		this.empleadoSinContratoVencido = new Empleado("Maria","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		
		this.empleado4Años = new Empleado("Juan","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		this.empleado5Años = new Empleado("Pedro","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		this.empleado10Años = new Empleado("Tamara","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		this.empleado15Años = new Empleado("Veronica","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		this.empleado20Años = new Empleado("Felipe","Diaz","123",LocalDate.of(2002, 10, 24),false, true);
		
		this.empleadoConContratoVencido.cargarContratoPorHoras(LocalDate.of(2015, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); // NO VENCIDO
		this.empleadoConContratoVencido.cargarContratoPorHoras(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 10, 23), 100, 100); // VENCIDO, ES EL VIGENTE
		this.empleadoConContratoVencido.cargarContratoDePlanta(LocalDate.of(2021, 10, 24), 100, 100, 100); 
		this.empleadoSinContratoVencido.cargarContratoDePlanta(LocalDate.of(2022, 10, 24), 100, 100, 100); //ES EL VIGENTE
		this.empleadoSinContratoVencido.cargarContratoPorHoras(LocalDate.of(2015, 9, 20), LocalDate.of(2022, 10, 23), 100, 100); //ESTA VENCIDO PERO COMO NO ES EL VIGENTE
		this.empleadoSinContratoVencido.cargarContratoPorHoras(LocalDate.of(2015, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); // NO VENCIDO
		
		this.empleado4Años.cargarContratoPorHoras(LocalDate.of(2018, 9, 20), LocalDate.of(2023, 10, 23), 100, 100);
		this.empleado4Años.cargarContratoPorHoras(LocalDate.of(2019, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); //VIGENTE
		this.empleado5Años.cargarContratoDePlanta(LocalDate.of(2017, 10, 24), 100, 100, 100);
		this.empleado5Años.cargarContratoDePlanta(LocalDate.of(2020, 10, 24), 100, 100, 100); //VIGENTE
		this.empleado10Años.cargarContratoDePlanta(LocalDate.of(2012, 10, 24), 100, 100, 100);
		this.empleado10Años.cargarContratoPorHoras(LocalDate.of(2019, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); //VIGENTE
		this.empleado15Años.cargarContratoPorHoras(LocalDate.of(2007, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); 
		this.empleado15Años.cargarContratoDePlanta(LocalDate.of(2012, 10, 24), 100, 100, 100); //VIGENTE
		this.empleado20Años.cargarContratoDePlanta(LocalDate.of(2002, 10, 24), 100, 100, 100);
		this.empleado20Años.cargarContratoPorHoras(LocalDate.of(2019, 9, 20), LocalDate.of(2023, 10, 23), 100, 100); //VIGENTE
		
		
	}

	@Test
	void testTieneContratoVencido() {
		assertTrue(empleadoConContratoVencido.tieneContratoVencido());
		assertFalse (empleadoSinContratoVencido.tieneContratoVencido());
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(4, this.empleado4Años.antiguedad());
		assertEquals(5, this.empleado5Años.antiguedad());
		assertEquals(10, this.empleado10Años.antiguedad());
		assertEquals(15, this.empleado15Años.antiguedad());
		assertEquals(20, this.empleado20Años.antiguedad());
	}

	@Test
	void testCalcularAumento() {
		assertEquals(0,this.empleado4Años.calcularAumento());
		assertEquals(0.3,this.empleado5Años.calcularAumento());
		assertEquals(0.5,this.empleado10Años.calcularAumento());
		assertEquals(0.7,this.empleado15Años.calcularAumento());
		assertEquals(1,this.empleado20Años.calcularAumento());
	}
	
	@Test
	void testCalcularMontoTotal() {
		assertEquals(10000,this.empleado4Años.calcularMontoTotal());
		assertEquals(260,this.empleado5Años.calcularMontoTotal());
		assertEquals(15000,this.empleado10Años.calcularMontoTotal());
		assertEquals(340,this.empleado15Años.calcularMontoTotal());
		assertEquals(20000,this.empleado20Años.calcularMontoTotal());
		
	}
	
}