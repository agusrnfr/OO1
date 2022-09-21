package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {
	
	private CuentaCorriente cuentaCorriente;

	@BeforeEach
	void setUp() throws Exception {
		cuentaCorriente = new CuentaCorriente();
	}

	@Test
	void testConstructor() {
		assertEquals(0,cuentaCorriente.getSaldo());
		assertEquals(0,cuentaCorriente.getDescubierto());
	}
	
	@Test
	void testDepositar() {
		cuentaCorriente.depositar(100);
		assertEquals(100,cuentaCorriente.getSaldo());
	}
	
	@Test
	void testExtraer() {
		assertFalse(cuentaCorriente.extraer(1));
		cuentaCorriente.depositar(100);
		cuentaCorriente.setDescubierto(100);
		assertTrue(cuentaCorriente.extraer(200));
		assertEquals(-100, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testTransferir() {
		Cuenta cuentaDestino = new CuentaCorriente();
		assertFalse(cuentaCorriente.transferirACuenta(1, cuentaDestino));
		cuentaCorriente.depositar(100);
		cuentaCorriente.setDescubierto(100);
		assertTrue(cuentaCorriente.transferirACuenta(200, cuentaDestino));
		assertEquals(-100, cuentaCorriente.getSaldo());
		assertEquals(200, cuentaDestino.getSaldo());
	}

}
