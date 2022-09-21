package ar.edu.unlp.info.oo1.ejercicio8_distribuidora;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;

	public Usuario(String nombre, String domicilio) {
		this.setNombre(nombre);
		this.setDomicilio(domicilio);
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMedicion (Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public void agregarFactura (Factura factura) {
		this.facturas.add(factura);
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}
	
	public double ultimoConsumoActiva() {
		if (this.ultimoConsumo() != null) {
			return this.ultimoConsumo().getConsumoEnergiaActiva();
		}
		else return 0;
	}
	
	public Consumo ultimoConsumo() {
		return this.consumos
				.stream()
				.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Factura factura;
		Consumo ultimoConsumo = this.ultimoConsumo();
		if (ultimoConsumo == null) {
			factura = new Factura(0,0,this);
		}
		else {
			int descuento = 0;
			if (ultimoConsumo.factorDePotencia() > 0.8) {
				descuento = 10;	
			}
				factura = new Factura(this.ultimoConsumo().constoEnBaseA(precioKWh),descuento,this);
		}
		this.agregarFactura(factura);
		return factura;
	}
}
