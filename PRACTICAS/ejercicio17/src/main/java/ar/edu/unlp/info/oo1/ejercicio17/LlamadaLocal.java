package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{

	public LlamadaLocal(String telefonoEmisor, String telefonoReceptor, LocalDateTime fechaComienzo, int duracion) {
		super(telefonoEmisor, telefonoReceptor, fechaComienzo, duracion);
	}
	
	@Override
	public double calcularCosto() {
		return super.calcularCosto(1);
	}

}
