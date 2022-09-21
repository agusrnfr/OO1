package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public double constoEnBaseA(double precioKWh) {
		return this.getConsumoEnergiaActiva() * precioKWh;
	}
	
	public double factorDePotencia() {
		return this.getConsumoEnergiaActiva() / (Math.sqrt((Math.pow (this.getConsumoEnergiaActiva(),2) + Math.pow(getConsumoEnergiaReactiva(), 2))));
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
}
