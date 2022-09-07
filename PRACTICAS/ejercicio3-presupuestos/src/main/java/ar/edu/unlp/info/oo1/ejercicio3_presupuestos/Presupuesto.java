package ar.edu.unlp.info.oo1.ejercicio3_presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private java.time.LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto() {
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public java.time.LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}

	public Presupuesto cliente(String cliente) {
		this.setCliente(cliente);
		return this;
	}
	
	public double calcularTotal() {
		return this.items.stream().mapToDouble(item -> item.costo()).sum();
	}

	public void agregarItem(Item item) {
		this.items.add(item);	
	}
	
	
	

}
