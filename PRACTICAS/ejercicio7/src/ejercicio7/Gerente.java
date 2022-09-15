package ejercicio7;

public class Gerente extends EmpleadoJerarquico{
	public Gerente(String string) {
		super(string);
	}

	public double aportes() {
		return this.montoBasico() * 0.05d;
	}
	
	public double montoBasico() {
		return 57000;
	}
}