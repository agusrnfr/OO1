package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

public class SeisCuotas implements Pago{

	@Override
	public double calcularPago(double monto) {
		return monto + monto * 0.2;
	}

}
