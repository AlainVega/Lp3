package clases.usuario;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class AngelInvestor extends Usuario {
	
	public int financiarOrg;		//id de la organizacion a la cual, el Angel Investor va a financiar.
	
	public AngelInvestor() {
		super();
		this.rol = "AI";
	}
	
	//Getter y Setter
	public int getFinanciarOrg() {
		return financiarOrg;
	}

	public void setFinanciarOrg(int financiarOrg) {
		this.financiarOrg = financiarOrg;
	}

}