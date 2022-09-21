package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura (double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
	}
	
	public double montoTotal() {
			return this.montoEnergiaActiva - this.montoEnergiaActiva * (this.getDescuento() / 100);
	}
	
	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public LocalDate getFecha () {
		return this.fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
}
