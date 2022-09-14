package ar.edu.unlp.info.oo1.ejercicio5_genealogia;

public class Mamifero {
	
	private String identificador;
	private String especie;
	private java.time.LocalDate fechaNacimiento;
	private Mamifero madre;
	private Mamifero padre;
	
	public Mamifero (String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero () {
		
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String id) {
		this.identificador = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public java.time.LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.time.LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	public Mamifero getMadre() {
		return this.madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public Mamifero getPadre() {
		return this.padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null)
			return this.getMadre().getMadre() ;
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null)
			return this.getMadre().getPadre() ;
		return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null)
			return this.getPadre().getMadre() ;
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null)
			return this.getPadre().getPadre() ;
		return null;	
	}
	

	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		if (unMamifero.equals(this.getPadre())|| unMamifero.equals(this.getMadre()))
			return true;
		if ((this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero)) ||
		    (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero)))
			return true;
		return false;
		
	}

/*	
	 public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		return ((unMamifero.equals(this.getPadre())|| unMamifero.equals(this.getMadre()))
				|| (this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero)) 
				|| (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero)));
	}

		*/
}
