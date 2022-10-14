package ar.edu.unlp.objetos.uno.ejercicio15_alquilerPropiedades;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	
	public Reserva(DateLapse periodo, Propiedad propiedad) {
		this.periodo = periodo;
		this.propiedad = propiedad;
	}
	
	public double calcularReserva() {
		return propiedad.calcularPrecio(periodo.sizeInDays());
		//return periodo.sizeInDays() * propiedad.getPrecioPorNoche(); --> no se cual es mejor solucion
	}
	
	public boolean overlaps (DateLapse another) {
		return periodo.overlaps(another);
	}
	
	public boolean inicioPosteriorFechaActual() {
		return periodo.laterFrom();
		
	}
	
	
	

}
