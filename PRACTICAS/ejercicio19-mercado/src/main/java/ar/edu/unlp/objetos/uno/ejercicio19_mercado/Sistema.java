package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Persona> usuarios;
	
	public Sistema () {
		this.usuarios = new ArrayList<Persona>();
	}
	
	public Persona registrarUsuario(String nombre, String direccion) {
		Persona usuario = new Persona (nombre,direccion);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Persona buscarUsuario (String nombre) {
		return this.usuarios.stream().filter(usuario -> usuario.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	public Producto cargarProducto (String nombre, String descripcion, double precio, int stock, Persona vendedor) {
		Producto producto = vendedor.cargarProducto(nombre, descripcion, precio, stock);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return this.usuarios.stream().map(usuario -> usuario.buscarProducto(nombre)).filter(producto -> producto != null).collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Producto producto, int cantidad, Pago pago, Envio envio, Persona cliente) {
		Pedido pedido = cliente.crearPedido(producto, cantidad, pago, envio);
		return pedido;
	}
	
	public double calcularCosto(Pedido pedido) {
		return pedido.calcularMontoTotal();
	}

}
