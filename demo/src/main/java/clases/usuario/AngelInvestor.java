package clases.usuario;

import javax.persistence.Entity;

@Entity
public class AngelInvestor extends Usuario {
	
	public int financiarOrg;
	public double cantidad;
	
	public AngelInvestor() {
		super();
		this.rol = "AI";
	}
	
	public int getFinanciarOrg() {
		return financiarOrg;
	}

	public void setFinanciarOrg(int financiarOrg) {
		this.financiarOrg = financiarOrg;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
}
