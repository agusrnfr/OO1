package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Empleado> empleados;
	
	public Empresa () {
		this.empleados = new ArrayList<Empleado>();
	}
	
	public Empleado altaEmpleado(String nombre, String apellido, String CUIL, 
			LocalDate fechaNacimiento, boolean conyugue, boolean hijos) {
		Empleado empleado = new Empleado (nombre, apellido, CUIL, fechaNacimiento, conyugue, hijos);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Empleado buscarEmpleado (String CUIL) {
		return this.empleados.stream().filter(empleado -> empleado.getCUIL().equals(CUIL)).findFirst().orElse(null);
	}
	
	public void bajaEmpleado (Empleado empleado) {
		this.empleados.remove(empleado);
		
	}
	
	public void cargarContratoPorHoras (Empleado empleado, LocalDate fechaInicio, 
			LocalDate fechaFin, double valorPorHora, int horasPorMes) {
		empleado.cargarContratoPorHoras(fechaInicio, fechaFin, valorPorHora, horasPorMes);
	}
	
	public void cargarContratoDePlanta (Empleado empleado, LocalDate fechaInicio, 
			double sueldoMensual, double montoPorConyugue, double montoPorHijos) {
		empleado.cargarContratoDePlanta(fechaInicio, sueldoMensual, montoPorConyugue, montoPorHijos);
	}
	
	public List<Empleado> obtenerEmpleadosConContratosVencidos(){
		return this.empleados.stream().filter(empleado -> empleado.tieneContratoVencido()).collect(Collectors.toList());
	}
	
	public List<Recibo> generarRecibos(){
		return this.empleados.stream().map(empleado -> empleado.generarRecibo()).collect(Collectors.toList());
	}

}
