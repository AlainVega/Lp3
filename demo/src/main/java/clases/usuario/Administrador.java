package clases.usuario;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
		this.rol = "AD";
	}
}
