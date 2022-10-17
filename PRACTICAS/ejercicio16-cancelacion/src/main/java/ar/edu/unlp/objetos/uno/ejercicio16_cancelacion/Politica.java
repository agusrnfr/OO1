package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.time.LocalDate;

public interface Politica {
	
	double calcularReembolso(LocalDate fechaCancelacion, LocalDate fechaInicio, double montoTotal);

}
