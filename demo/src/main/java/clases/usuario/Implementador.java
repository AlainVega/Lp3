package clases.usuario;

import javax.persistence.Entity;

@Entity
public class Implementador extends Usuario {

	public String profesion;
	
	public Implementador() {
		super();
		this.rol = "IM";
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
}
