package ar.edu.unlp.info.oo1.ejercicio4_figurasYCuerpos;

public class Circulo implements Figura{
	
	private double radio;

//GETTER Y SETTER RADIO
	
	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
//GETTER Y SETTER DIAMETRO
	
	public double getDiametro() {
		return this.getRadio()*2;
	}

	public void setDiametro(double valor) {
		this.setRadio(valor/2);
	}

//AREA Y PERIMETRO	
	
	@Override
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}

	@Override
	public double getArea() {
		return (Math.PI * (Math.pow(this.getRadio(), 2)));
	}

}
