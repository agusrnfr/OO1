package ar.edu.unlp.info.oo1.ejercicio20_farolasConFocos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farola {
	private boolean on;
	private Foco foco;
	private List<Farola> neighbors;
	
	/*
	 * Crear una farola que posee un foco fabricado por fabricante con cantidad de
	 * ciclos el valor de cantidadDeCiclos. Debe inicializarla como apagada
	 */
	
	public Farola (String fabricante, int cantidadDeCiclos){
		this.neighbors = new ArrayList<Farola>();
		this.on = false;
		this.foco = new Foco (fabricante,cantidadDeCiclos);
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	
	public void pairWithNeighbor( Farola otraFarola ) {
		if (!this.neighbors.contains(otraFarola)) {
			this.neighbors.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	
	public List<Farola> getNeighbors (){
		return this.neighbors;
	}

	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	
	public void turnOn() {
		if (!this.isOn() && !this.foco.estaVencido()) {
			this.on = true;
			this.foco.decrementarCiclo();
			this.getNeighbors().forEach(l -> l.turnOn());
		}
	}

	/*
	* Si la farola no está encendida, la enciende, contabiliza el ciclo de encendido y propaga la acción. 
	*/
	
	public void turnOff() {
		if (this.isOn()) {
			this.on = false;
			this.getNeighbors().forEach(farola -> farola.turnOff());
		}
	}

	/*
	* Retorna true si la farola está encendida.
	*/
	
	public boolean isOn() {
		return this.on;
	}
	
	public boolean focoVencido() {
		return this.foco.estaVencido();
	}
	
	private List<Farola> conseguirRedFarolas(List<Farola> lista){
		if (!lista.contains(this)) {
			lista.add(this);
			this.neighbors.stream().forEach(farola -> farola.conseguirRedFarolas(lista));
		}
		
		return lista;
		
	}
	
	
	/*
	* Retorna una lista con las farolas que están en la red de la farola receptora y que poseen focos vencidos. Incluyendo el chequeo entre las farolas vecinas y las vecinas de estas propagando en toda la red.
	*/
	public List<Farola> farolasConFocosVencidos(){
		List<Farola> lista = new ArrayList<Farola>();
		this.conseguirRedFarolas(lista);
		return lista.stream().filter(farola -> farola.focoVencido()).collect(Collectors.toList());
	}
	
	public int getCantidadMaximaCiclos() {
		return this.foco.getCantidadMaximaCiclos();
	}
	

}
