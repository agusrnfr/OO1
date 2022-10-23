package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(String telefonoEmisor, String telefonoReceptor, LocalDateTime fechaComienzo, int duracion, String paisOrigen, String paisDestino) {
		super(telefonoEmisor, telefonoReceptor, fechaComienzo, duracion);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}
	
	@Override
	public double calcularCosto() {
		double monto;
		if ((this.getFechaComienzo().getHour() >= 8 && this.getFechaComienzo().getMinute() >= 0) && (this.getFechaComienzo().getHour() < 20)) {
			monto = super.calcularCosto(4);
			}
		else monto = super.calcularCosto(3);
		return monto;
	}
	
	

}
