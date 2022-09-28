package ar.edu.unlp.info.oo1.ejercicio12_solidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza (Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public List<Pieza> getPiezas() {
		return piezas;
	}
	
	public double getVolumenDeMaterial (String material) {
		return this.piezas
				.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.mapToDouble(pieza -> pieza.getVolumen())
				.sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.piezas
				.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(pieza -> pieza.getSuperficie())
				.sum();
	}

}
