package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	
	public Reserva(DateLapse periodo, Propiedad propiedad) {
		this.periodo = periodo;
		this.propiedad = propiedad;
	}
	
	public double calcularReserva() {
		//return propiedad.calcularPrecio(periodo.sizeInDays());--> no se cual es mejor solucion
		return periodo.sizeInDays() * propiedad.getPrecioPorNoche(); 
	}
	
	public double calcularReembolso(LocalDate fechaCancelacion) {
		return propiedad.getPolitica().calcularReembolso(fechaCancelacion, this.periodo.getFrom(), this.calcularReserva());
	}
	
	public boolean overlaps (DateLapse another) {
		return periodo.overlaps(another);
	}
	
	public boolean inicioPosteriorFechaActual() {
		return periodo.laterFrom();
		
	}
	
	
	

}
