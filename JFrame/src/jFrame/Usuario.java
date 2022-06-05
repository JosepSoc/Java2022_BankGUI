package jFrame;

public class Usuario {
	private String nombre;
	private String pin;
	private boolean estado;
	private String codCuenta;
	private int cCorriente;
	private int cAhorro;
	private int efectivo;
	
	public Usuario(String nombre, String pin, boolean estado, String codCuenta, int cCorriente, int cAhorro, int efectivo) {
		this.setNombre(nombre);
		this.setPin(pin);
		this.setEstado(estado);
		this.setCodCuenta(codCuenta);
		this.setcCorriente(cCorriente);
		this.setcAhorro(cAhorro);
		this.setEfectivo(efectivo);
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}

	public int getcCorriente() {
		return cCorriente;
	}

	public void setcCorriente(int cCorriente) {
		this.cCorriente = cCorriente;
	}

	public int getcAhorro() {
		return cAhorro;
	}

	public void setcAhorro(int cAhorro) {
		this.cAhorro = cAhorro;
	}

	public int getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(int efectivo) {
		this.efectivo = efectivo;
	}
}
