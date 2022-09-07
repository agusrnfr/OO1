package ar.edu.unlp.info.oo1.ejercicio4_figurasYCuerpos;

public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;

//GETTER Y SETTER ALTURA
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
//GETTER Y SETTER CARA BASAL
	public Figura getCaraBasal() {
		return caraBasal;
	}
	
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	
//AREA Y VOLUMEN
	
	public double getSuperficieExterior() {
		return (2 * this.getCaraBasal().getArea() + this.getCaraBasal().getPerimetro() * this.getAltura());
	}
	
	public double getVolumen() {
		return (this.getCaraBasal().getArea() * this.getAltura());
	}	
	
	

}
