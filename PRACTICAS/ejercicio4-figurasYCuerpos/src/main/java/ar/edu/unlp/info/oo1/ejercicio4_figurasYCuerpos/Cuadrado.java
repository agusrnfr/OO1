package ar.edu.unlp.info.oo1.ejercicio4_figurasYCuerpos;

public class Cuadrado implements Figura{
	
	private double lado;
	
// GETTER Y SETTER LADO

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

//AREA Y PERIMETRO

	@Override
	public double getPerimetro() {
		return (this.getLado()*4);
	}

	@Override
	public double getArea() {
		return (Math.pow(this.getLado(), 2));
	}

}
