package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	private Sistema sistema;
	
	private Pedido AlContadoCorreo;
	private Pedido AlContadoADomicilio;
	private Pedido SeisCuotasComercio;
	
	private Producto producto;
	private Persona cliente1;
	private Persona vendedor;

	@BeforeEach
	void setUp() throws Exception {
		this.sistema = new Sistema();
		this.cliente1 = this.sistema.registrarUsuario("Pepe", "Diaz");
		this.vendedor = this.sistema.registrarUsuario("Shakira", "123");
		this.producto = this.sistema.cargarProducto("Pr1", "descr", 100, 10, this.vendedor);
	}

	@Test
	void testCrearPedido() {
		assertNull(this.sistema.crearPedido(producto, 11, new AlContado(), new RetirarCorreo(), cliente1));
		assertEquals(10,this.producto.getStock());
		assertNotNull(this.sistema.crearPedido(producto, 10, new AlContado(), new RetirarCorreo(), cliente1));
		assertEquals(0,this.producto.getStock());
	}
	
	@Test
	void testBuscarProducto() {
		assertTrue(this.sistema.buscarProducto("Pr1").contains(producto));
		assertEquals(1,this.sistema.buscarProducto("Pr1").size());
		assertTrue(this.sistema.buscarProducto("123").isEmpty());
	}
	
	@Test
	void testBuscarUsuario() {
		assertEquals(this.vendedor, this.sistema.buscarUsuario("Shakira"));
		assertNull(this.sistema.buscarUsuario("Josesito"));
	}
	
	@Test
	void testPedidoAlContadoCorreo() {
		this.AlContadoCorreo = this.sistema.crearPedido(producto, 10, new AlContado(), new RetirarCorreo(), cliente1);
		assertEquals(1050,this.sistema.calcularCosto(AlContadoCorreo));
	}
	
	@Test
	void testPedidoAlContadoADomicilio() {
		this.AlContadoADomicilio = this.sistema.crearPedido(producto, 10, new AlContado(), new ADomicilio(), cliente1);
		assertEquals(1050,this.sistema.calcularCosto(AlContadoADomicilio));
	}
	
	@Test
	void testSeisCuotasComercio() {
		this.SeisCuotasComercio = this.sistema.crearPedido(producto, 10, new SeisCuotas(), new RetirarComercio(), cliente1);
		assertEquals(1200,this.sistema.calcularCosto(SeisCuotasComercio));
	}

}
