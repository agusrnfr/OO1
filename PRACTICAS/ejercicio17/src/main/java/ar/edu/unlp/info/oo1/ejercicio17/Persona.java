package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private String nroTelefono;
	private List<Llamada> llamadas;
	private List<Factura> facturas;
	
	public Persona (String nombre, String direccion, String nroTelefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nroTelefono = nroTelefono;
		this.llamadas = new ArrayList<Llamada>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor) {
		LlamadaLocal llamada = new LlamadaLocal(nroEmisor,nroReceptor, fecha,duracion);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor, double KM) {
		LlamadaInterurbana llamada = new LlamadaInterurbana (nroEmisor, nroReceptor, fecha, duracion, KM);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor, String paisDestino, String paisOrigen) {
		LlamadaInternacional llamada = new LlamadaInternacional (nroEmisor, nroReceptor, fecha,  duracion, paisOrigen, paisDestino);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Factura facturar (LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		Factura factura = new Factura (fechaInicio,fechaFin, this, this.calcularMontoTotal(fechaInicio, fechaFin));
		return factura;
	}
	
	public double calcularMontoTotal(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.llamadas.stream().filter(llamada -> llamada.isInLapse(fechaInicio,fechaFin)).mapToDouble(llamada -> llamada.calcularCosto()).sum();	
	}
	
	public List<Factura> getFacturas(){
		return this.facturas;
	}
	
	public List<Llamada> getLlamadas(){
		return this.llamadas;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

}
