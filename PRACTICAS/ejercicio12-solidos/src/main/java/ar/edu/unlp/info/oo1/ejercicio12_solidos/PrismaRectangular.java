package ar.edu.unlp.info.oo1.ejercicio12_solidos;

public class PrismaRectangular extends Pieza{
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public int getLadoMayor() {
		return ladoMayor;
	}
	
	public void setLadoMayor(int ladoMayor) {
		this.ladoMayor = ladoMayor;
	}
	
	public int getLadoMenor() {
		return ladoMenor;
	}
	
	public void setLadoMenor(int ladoMenor) {
		this.ladoMenor = ladoMenor;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public double getVolumen() {
		return this.getLadoMayor() * this.getLadoMenor() * this.getAltura();
	}
	@Override
	public double getSuperficie() {
		return 2 * (this.getLadoMayor() * this.getLadoMenor() 
				+ this.getLadoMayor() * this.getAltura() 
				+ this.getLadoMenor() * this.getAltura());
	}
	
	
}
