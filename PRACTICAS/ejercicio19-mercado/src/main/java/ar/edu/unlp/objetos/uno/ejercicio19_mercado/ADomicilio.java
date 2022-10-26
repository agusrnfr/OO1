package ar.edu.unlp.objetos.uno.ejercicio19_mercado;

public class ADomicilio implements Envio {
	private Mapa mapa;
	
	public ADomicilio() {
		this.mapa = new Mapa();
	}
	
	@Override
	public double calcularEnvio(String dir1, String dir2) {
		return 0.5 * this.mapa.distanciaEntre(dir1,dir2);
	}

}
