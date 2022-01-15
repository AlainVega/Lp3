package clases.usuario;

public class Sponsor extends Usuario {

	public String financiar_cat;
	private double cantidad;

	public String getFinanciar_cat() {
		return financiar_cat;
	}

	public void setFinanciar_cat(String financiar_cat) {
		this.financiar_cat = financiar_cat;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
}
