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
	
	//AGREGAR AL PROPIETARIO LA PROPIEDAD ( NO SE PORQUE NO LO HICE )
	
	public Propiedad registrarPropiedad (String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario, Politica politica){
		Propiedad propiedad = new Propiedad (nombre, descripcion, direccion, precioPorNoche, propietario, politica);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> listarPropiedadesDisponibles (DateLapse periodo){
		//CAMBIAR DISPONIBILIDAD A estaDisponible para que se entienda mas.
		return this.propiedades.stream().filter(propiedad -> propiedad.disponibilidad(periodo)).collect(Collectors.toList());
	}
	
	public Reserva realizarReserva (Propiedad propiedad, DateLapse periodo, Usuario usuario){
		if (propiedad.disponibilidad(periodo)){
			//EL OBJETO LO INSTANCIA EL QUE LO USA
			Reserva reserva = new Reserva (periodo, propiedad); // ESTO PODRIA INSTANCIARLO EL USUARIO O LA PROPIEDAD Y RETORNAR EL METODO PARA QUE EL OTRO ME LO AGREGUE. LA ELECCION ES CUALQUIERA, SI ES UNA SOLA CLASE EL QUE LO USA AHI VA DIRECTO ESA.
			usuario.agregarReserva(reserva);
			propiedad.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	//ESTARIA MEJOR QUE LA RESERVA CONOZCA AL DUEÑO Y A LA PROPIEDAD Y DIGA CHE ELIMINAME, QUE EL ELIMINAR LO TENGA LA RESERVA PROPIA, SI NO SON UNA GRAN CANTIDAD DE MENSAJES
	
	public void eliminarReserva (Reserva reserva){
		if (reserva.inicioPosteriorFechaActual()) {
			this.usuarios.stream().forEach(usuario -> usuario.eliminarReserva(reserva));
			this.propiedades.stream().forEach(propiedad -> propiedad.eliminarReserva(reserva));
		}
	}

	public List<Reserva> obtenerReservaUsuario (Usuario usuario){
		return usuario.getReservas(); // TA OK ESTO
	}
	
	public double calcularIngresoPropietario (Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresoPropietario(periodo);
	}
	
	//LA POLITICA AGREGAR.
}
