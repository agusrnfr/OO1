package ar.edu.unlp.info.oo1.ejercicio3_presupuestos;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public String getDetalle() {
		return this.detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCostoUnitario() {
		return this.costoUnitario;
	}
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public double costo() {
		return (this.getCantidad() * this.getCostoUnitario());
	}
	
	public Item detalle(String detalle) {
		this.setDetalle(detalle);
		return this;
	}
	public Item costoUnitario(int costoUnitario) {
		this.setCostoUnitario(costoUnitario);
		return this;
	}
	public Item cantidad(int cantidad) {
		this.setCantidad(cantidad);
		return this;
	}
	
	

}
