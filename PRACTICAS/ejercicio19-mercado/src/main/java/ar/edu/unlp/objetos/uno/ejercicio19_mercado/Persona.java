package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String nombre;
	private String direccion;
	private List<Producto> productos;
	private List<Pedido> pedidos;
	
	public Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Producto cargarProducto (String nombre, String descripcion, double precio, int stock) {
		Producto producto = new Producto (nombre,descripcion,precio,stock, this);
		this.productos.add(producto);
		return producto;
	}
	
	public Producto buscarProducto(String nombre) {
		return this.productos.stream().filter(producto -> producto.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	public Pedido crearPedido(Producto producto, int cantidad, Pago pago, Envio envio) {
		if (producto.tieneUnidades(cantidad)) {
			Pedido pedido = new Pedido(producto, cantidad, pago, envio, this);
			producto.decrementarStock(cantidad);
			this.pedidos.add(pedido);
			return pedido;
		}
		return null;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNombre() {
		return nombre;
	}
	
	

}
