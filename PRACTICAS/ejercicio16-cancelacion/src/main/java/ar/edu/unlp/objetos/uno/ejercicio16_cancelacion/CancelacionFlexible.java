package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.time.LocalDate;

public class CancelacionFlexible implements Politica {

	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double montoTotal) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			return montoTotal;}
		return 0;
	}

}
