package ar.edu.unlp.info.oo1.ejercicio2;

//import java.time.LocalDate;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
	}
	
	public Ticket emitirTicket () {
		/*Ticket ticket = new Ticket();
		ticket.setCantidadDeProductos(this.getCantidadDeProductos());
		ticket.setFecha(LocalDate.now());
		ticket.setPesoTotal(this.getPesoTotal());
		ticket.setPrecioTotal(this.getPrecioTotal());*/
		Ticket ticket = new Ticket(this.getCantidadDeProductos(),this.getPesoTotal(),this.getPrecioTotal());
		return ticket;
	}
	
}
