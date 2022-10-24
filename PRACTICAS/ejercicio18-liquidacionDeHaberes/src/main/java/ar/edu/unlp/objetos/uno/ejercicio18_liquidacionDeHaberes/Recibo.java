package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class Recibo {
	private Empleado empleado;
	private int antiguedad;
	private LocalDate fecha;
	private double montoTotal;
	
	public Recibo(Empleado empleado, int antiguedad, double montoTotal) {
		this.empleado = empleado;
		this.antiguedad = antiguedad;
		this.fecha = LocalDate.now();
		this.montoTotal = montoTotal;
	}
	
	

}
