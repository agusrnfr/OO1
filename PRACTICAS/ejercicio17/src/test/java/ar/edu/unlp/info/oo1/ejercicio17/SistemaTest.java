package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	private Sistema sistema = new Sistema();
	private Persona fisica1;
	private Persona fisica2;
	private Persona juridica1;

	@BeforeEach
	void setUp() throws Exception {
		this.sistema.agregarNumero("221232232");
		this.sistema.agregarNumero("221234232");
		this.sistema.agregarNumero("221654824");
		
		this.fisica1= this.sistema.agregarPersonaFisica("Pepito", "Avenida Siempre Viva 742", "44212212");
		this.fisica2 =this.sistema.agregarPersonaFisica("Jose", "Avenida Siempre Viva 762", "44212212");
		this.juridica1 = this.sistema.agregarPersonaJuridica("Holas", "Dir1", "cuit", "tipo");
	}

	@Test
	void testRegistrarLlamada() {
		this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 6, 16, 31), 10, "221232232", "221654824");
		Factura factura1 = this.sistema.facturar(fisica1, LocalDateTime.of(2022, 10, 6, 16, 29), LocalDateTime.of(2022, 10, 6, 16, 37));
		this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 6, 16, 35), 10, "221232232", "221654824");
		assertEquals(2,this.fisica1.getLlamadas().size());
	}
	
	@Test
	void testFacturar() {
		this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 6, 16, 31), 10, "221232232", "221654824");
		this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 6, 16, 35), 10, "221232232", "221654824");
		Factura factura1 = this.sistema.facturar(fisica1, LocalDateTime.of(2022, 10, 6, 16, 29), LocalDateTime.of(2022, 10, 6, 16, 37));
		assertEquals(18,factura1.getMontoTotal());
		this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2022, 10, 6, 16, 31), 10, "221234232", "221654824",99);
		Factura factura2 = this.sistema.facturar(fisica2, LocalDateTime.of(2022, 10, 6, 16, 31), LocalDateTime.of(2022, 10, 6, 16, 37));
		assertEquals(22.5,factura2.getMontoTotal());
		this.sistema.registrarLlamadaInternacional(LocalDateTime.of(2022, 10, 23, 20, 1), 10, "221654824", "221234232","Argentina", "Arabia Saudita");
		Factura factura3 = this.sistema.facturar(juridica1, LocalDateTime.of(2022, 10, 23, 20, 1), LocalDateTime.of(2022, 10, 23, 20, 10));
		assertEquals(30,factura3.getMontoTotal());
	}

}
