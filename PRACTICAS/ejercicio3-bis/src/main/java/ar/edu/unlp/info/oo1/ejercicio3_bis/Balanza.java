package ar.edu.unlp.info.oo1.ejercicio3_bis;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza {
	
	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}

	public double getPesoTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}
	
	public void ponerEnCero() {
		this.productos.clear();
		//this.productos = new ArrayList<Producto>(); 
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket () {
		Ticket ticket = new Ticket(this.getCantidadDeProductos(),this.getPesoTotal(),this.getPrecioTotal(),this.getProductos());
		//NO TIENE SENTIDO CALCULAR DE NUEVO LOS VALORES EN EL TICKET
		return ticket;
	}
	
	/*
	
	 TAREA 1: 	Produce que se tenga que borrar los datos de la lista en cada ponerEnCero
	 			No, no es necesario, se puede trabajar con la lista de productos.
	 TAREA 2:   Le agregaria una lista de productos que se setea con el constructor o un setter.
	 
	 TAREA 3:	Si, sigue pasando los test. Esta bien que sea asi porque solo se cambio el estado interno del objeto,
	 pero sigue respondiendo a los mensajes de la misma manera.
	 
	  
	  
	 */
	
}
