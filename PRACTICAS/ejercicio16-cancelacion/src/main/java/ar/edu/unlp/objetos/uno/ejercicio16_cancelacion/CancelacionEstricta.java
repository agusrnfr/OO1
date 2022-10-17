package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.time.LocalDate;

public class CancelacionEstricta implements Politica {

	@Override
	public double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double montoTotal) {
		return 0;
	}

}
