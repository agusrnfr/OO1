package ar.edu.unlp.objetos.uno.ejercicio16_cancelacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeAlquileres {
	
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario registrarUsuario (String nombre, String direccion, String dni){
		Usuario usuario = new Usuario (nombre, direccion, dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Propiedad registrarPropiedad (String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario, Politica politica){
		Propiedad propiedad = new Propiedad (nombre, descripcion, direccion, precioPorNoche, propietario, politica);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> listarPropiedadesDisponibles (DateLapse periodo){
		return this.propiedades.stream().filter(propiedad -> propiedad.disponibilidad(periodo)).collect(Collectors.toList());
	}
	
	public Reserva realizarReserva (Propiedad propiedad, DateLapse periodo, Usuario usuario){
		if (propiedad.disponibilidad(periodo)){
			Reserva reserva = new Reserva (periodo, propiedad);
			usuario.agregarReserva(reserva);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	public void eliminarReserva (Reserva reserva){
		if (reserva.inicioPosteriorFechaActual()) {
			this.usuarios.stream().forEach(usuario -> usuario.eliminarReserva(reserva));
			this.propiedades.stream().forEach(propiedad -> propiedad.eliminarReserva(reserva));
		}
	}

	public List<Reserva> obtenerReservaUsuario (Usuario usuario){
		return usuario.getReservas();
	}
	
	public double calcularIngresoPropietario (Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresoPropietario(periodo);
	}
}
