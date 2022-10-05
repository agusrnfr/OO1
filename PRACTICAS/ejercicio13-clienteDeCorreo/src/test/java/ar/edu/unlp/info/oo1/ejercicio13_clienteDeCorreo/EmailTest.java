package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	
	private Email emailConAdjuntos;
	private Email emailSinAdjuntos;
	private Archivo archivo;
	private Archivo archivo2;

	@BeforeEach
	void setUp() throws Exception {
		this.emailConAdjuntos = new Email ("SoyUnMail","12345Hola");
		this.emailSinAdjuntos = new Email ("Soy","12345Hola");
		this.archivo = new Archivo("LanaDelRey");
		this.archivo2 = new Archivo("TaylorSwift");
		
	}

	@Test
	void testConstructor() {
		assertEquals("SoyUnMail",this.emailConAdjuntos.getTitulo());
		assertEquals("12345Hola",this.emailConAdjuntos.getCuerpo());
		assertNotNull(this.emailConAdjuntos.adjuntos());
	}
	
	@Test
	void testEspacioOcupado() {
		this.emailConAdjuntos.agregarAdjuntos(archivo);
		this.emailConAdjuntos.agregarAdjuntos(archivo2);
		assertEquals(39.00,this.emailConAdjuntos.espacioOcupado());
		assertEquals(12.00,this.emailSinAdjuntos.espacioOcupado());
	}
	
	@Test
	void contiene() {
		assertTrue(this.emailSinAdjuntos.contiene("12345"));
		assertFalse(this.emailSinAdjuntos.contiene("Mail"));
		
	}

}
