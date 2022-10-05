package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	
	private Carpeta carpetaConEmails;
	private Carpeta carpetaSinEmails;
	private Email email;
	private Email email2;

	@BeforeEach
	void setUp() throws Exception {
		this.carpetaConEmails = new Carpeta("TengoMails");
		this.carpetaSinEmails = new Carpeta("NoTengoMails");
		this.email= new Email ("SoyUnMail","12345Hola");
		this.email2= new Email ("Soy","12");
		
	}

	@Test
	void testAgregarYRemoverCorreo() {
		this.carpetaConEmails.agregarCorreo(email);
		assertEquals(1,this.carpetaConEmails.getEmails().size());
		this.carpetaConEmails.removerCorreo(email);
		assertEquals(0,this.carpetaConEmails.getEmails().size());
		
	}
	
	@Test
	void testBuscar() {
		this.carpetaConEmails.agregarCorreo(email);
		assertEquals(this.email,this.carpetaConEmails.buscar("12345Hola"));
		assertNull(this.carpetaSinEmails.buscar("1234"));
	}
	
	@Test
	void testEspacioOcupado() {
		this.carpetaConEmails.agregarCorreo(email);
		this.carpetaConEmails.agregarCorreo(email2);
		assertEquals(23.00,this.carpetaConEmails.espacioOcupado());
		
	}

}
