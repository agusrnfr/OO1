package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

public class Pedido {
	private int cantidad;
	private Persona cliente;
	private Producto producto;
	private Pago metodoPago;
	private Envio metodoEnvio;
	
	public Pedido(Producto producto, int cantidad, Pago pago, Envio envio, Persona cliente) {
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.producto = producto;
		this.metodoPago = pago;
		this.metodoEnvio = envio;
	}
	
	public double calcularMontoTotal() {
		return this.metodoPago.calcularPago(this.calcularPrecio()) + 
				this.metodoEnvio.calcularEnvio(this.direccionCliente(), this.producto.direccionVendedor());
	}
	
	public double calcularPrecio() {
		return this.producto.calcularPrecioEnBaseACantidad(this.cantidad);
	}
	
	public String direccionCliente() {
		return this.cliente.getDireccion();
	}
	
	

}
