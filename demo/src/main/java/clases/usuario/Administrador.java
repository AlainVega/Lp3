package clases.usuario;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
		this.rol = "AD";
	}
}
