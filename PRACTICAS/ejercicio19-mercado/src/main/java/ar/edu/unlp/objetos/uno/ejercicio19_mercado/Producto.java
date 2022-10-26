package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Persona vendedor;
	
	public Producto(String nombre, String descripcion, double precio, int stock, Persona vendedor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.vendedor = vendedor;
	}
	
	public void decrementarStock (int cant) {
		this.stock-=cant;
	}
	
	public boolean tieneUnidades(int cantidad) {
		return (this.stock - cantidad >= 0);
		
	}
	public String direccionVendedor() {
		return this.vendedor.getDireccion();
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getStock() {
		return stock;
	}
	
	public double calcularPrecioEnBaseACantidad(int cantidad) {
		return this.precio * cantidad;
	}

}
