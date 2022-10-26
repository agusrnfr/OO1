package ar.edu.unlp.info.oo1.ejercicio20_farolasConFocos;

public class Foco {
	private String empresa;
	private int cantidadMaximaCiclos;
	
	public Foco(String empresa, int cantidadMaximaCiclos) {
		this.empresa = empresa;
		this.cantidadMaximaCiclos = cantidadMaximaCiclos;
	}
	
	public void decrementarCiclo() {
		this.cantidadMaximaCiclos-=1;
	}
	
	public boolean estaVencido() {
		return this.cantidadMaximaCiclos <=0; // si es menor o igual a 0, ta vencido
	}
	
	public int getCantidadMaximaCiclos() {
		return this.cantidadMaximaCiclos;
	}
	
	

}
