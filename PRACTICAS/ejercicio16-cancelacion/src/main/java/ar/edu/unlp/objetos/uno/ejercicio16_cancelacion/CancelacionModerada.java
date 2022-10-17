package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionModerada implements Politica{
	
	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double montoTotal) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			if ((int) fechaCancelacion.until(fechaInicio,ChronoUnit.DAYS) > 2) {
				return montoTotal;
				}
			else {
				return montoTotal / 2;
				}
	}
	return 0;
}

}