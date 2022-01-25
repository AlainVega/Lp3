package clases.usuario;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Sponsor extends Usuario {
	
	public String financiarCat;		//Categoria a financiar por el Sponsor
	
	public Sponsor() {
		super();
		this.rol = "SP";
	}
	
	//Getter y Setter
	public String getFinanciarCat() {
		return financiarCat;
	}

	public void setFinanciarCat(String financiarCat) {
		this.financiarCat = financiarCat;
	}
	
}
