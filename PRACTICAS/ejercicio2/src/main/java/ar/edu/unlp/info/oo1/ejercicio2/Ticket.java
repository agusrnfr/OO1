package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;

public class Ticket {
	private java.time.LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket() {
		
	}
	
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal) {
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.fecha = LocalDate.now();
	}
	
	public java.time.LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double impuesto() {
		return (this.getPrecioTotal() * 0.21);
	}
	

}
