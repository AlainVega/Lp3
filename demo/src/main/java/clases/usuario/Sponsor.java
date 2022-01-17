package clases.usuario;

public class Sponsor extends Usuario {

	public String financiarCat;
	private double cantidad;

	public String getFinanciarCat() {
		return financiarCat;
	}

	public void setFinanciarCat(String financiarCat) {
		this.financiarCat = financiarCat;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
}
