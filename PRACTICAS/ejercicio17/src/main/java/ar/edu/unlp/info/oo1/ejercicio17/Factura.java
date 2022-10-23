package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class Factura {
	private LocalDateTime fechaFacturacion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private double montoTotal;
	private Persona cliente;
	
	public Factura(LocalDateTime fechaInicio, LocalDateTime fechaFin, Persona cliente, double montoTotal) {
		this.fechaFacturacion = LocalDateTime.now();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cliente = cliente;
		this.montoTotal = montoTotal;
	}

	public LocalDateTime getFechaFacturacion() {
		return fechaFacturacion;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public Persona getCliente() {
		return cliente;
	}

	public double getMontoTotal() {
		return montoTotal;
	}
}
