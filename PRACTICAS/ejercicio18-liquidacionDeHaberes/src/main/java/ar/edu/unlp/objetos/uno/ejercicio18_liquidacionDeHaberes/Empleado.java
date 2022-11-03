package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empleado {
	private String nombre;
	private String apellido;
	private String CUIL;
	private LocalDate fechaNacimiento;
	private boolean tieneConyugue;
	private boolean tieneHijos;
	private LocalDate fechaInicioRelacionLaboral;
	private List<Contrato> contratos;
	
	public Empleado (String nombre, String apellido, String CUIL, 
			LocalDate fechaNacimiento, boolean conyugue, boolean hijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.fechaNacimiento = fechaNacimiento;
		this.tieneConyugue = conyugue;
		this.tieneHijos = hijos;
		this.fechaInicioRelacionLaboral = LocalDate.now();
		this.contratos = new ArrayList<Contrato>();
		
	}
	
	public String getCUIL() {
		return this.CUIL;
	}
	
	public void cargarContratoPorHoras (LocalDate fechaInicio, 
			LocalDate fechaFin, double valorPorHora, int horasPorMes) {
		if (this.tieneContratoVencido()) {
		PorHoras contrato = new PorHoras (this, fechaInicio, fechaFin, valorPorHora, horasPorMes);
		this.contratos.add(contrato);
		}
	}
	
	public void cargarContratoDePlanta (LocalDate fechaInicio, 
			double sueldoMensual, double montoPorConyugue, double montoPorHijos) {
		if (this.tieneContratoVencido()) {
		DePlanta contrato = new DePlanta (this, fechaInicio, sueldoMensual, montoPorConyugue, montoPorHijos);
		this.contratos.add(contrato);
		}
		
	}
	
	public boolean tieneContratoVencido() {
		return this.contratoVigente().map(contrato -> contrato.estaVencido()).orElse(true);
	}
	
	public int antiguedad() {
		return this.contratos.stream()
				.mapToInt(contrato -> contrato.calcularAnios())
				.sum();
	}
	
	public Recibo generarRecibo() {
		return new Recibo (this, this.antiguedad(), this.calcularMontoTotal());
	}
	
	public double calcularAumento() {
		if (this.antiguedad() >= 5 && this.antiguedad() < 10) {
			return 0.3;
		}
		else if (this.antiguedad() >= 10 && this.antiguedad() < 15) {
			return 0.5;
		}
		else if (this.antiguedad() >= 15 && this.antiguedad() < 20) {
			return 0.7;
			}
			else if (this.antiguedad() >= 20) {
				return 1;}
		return 0;
		}
	
	private Optional<Contrato> contratoVigente() {
		return this.contratos.stream().max((Contrato c1, Contrato c2)-> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public double calcularMontoTotal() {
		if (!this.tieneContratoVencido()) {
		return this.contratoVigente().map(contrato -> contrato.calcularMonto() + contrato.calcularMonto() * this.calcularAumento()).orElse(0d);
		}
		return 0;
	}

	public boolean tieneConyugue() {
		return tieneConyugue;
	}

	public boolean tieneHijos() {
		return tieneHijos;
	}

}
