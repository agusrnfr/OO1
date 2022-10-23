package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {
	private double KM;

	public LlamadaInterurbana(String telefonoEmisor, String telefonoReceptor, LocalDateTime fechaComienzo, int duracion, double KM) {
		super(telefonoEmisor, telefonoReceptor, fechaComienzo, duracion);
		this.KM = KM;
	}
	
	@Override
	public double calcularCosto() {
		double monto;
		if (this.KM < 100) {
			monto = super.calcularCosto(2);
		}
		else if (this.KM >= 100 && this.KM <= 500){
			monto = super.calcularCosto(2.5);
		}
		else monto = super.calcularCosto(3);
		return monto + 5;
	}
	
	
	

}
