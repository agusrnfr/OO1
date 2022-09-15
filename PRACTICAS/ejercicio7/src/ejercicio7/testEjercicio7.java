package ejercicio7;

public class testEjercicio7 {

	public static void main(String[] args) {
		Gerente alan = new Gerente("Alan Turing");
		double aportesDeAlan = alan.aportes();
		
		Gerente alan2 = new Gerente("Alan Turing");
		double sueldoBasicoDeAlan = alan.sueldoBasico();
		
		System.out.println("1) " + aportesDeAlan);
		System.out.println("2) " + sueldoBasicoDeAlan);

	}

}
