package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

public abstract class Cuenta {
	private double saldo;

	public Cuenta () {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar (double monto) {
		this.saldo += monto;
	}

	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	
	public boolean extraer(double monto) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}

	public abstract boolean puedeExtraer (double monto);
	
}
