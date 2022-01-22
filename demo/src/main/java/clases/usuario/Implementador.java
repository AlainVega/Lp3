package clases.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Implementador extends Usuario {

	public ArrayList<String> asignaciones;
	
	public Implementador() {
		super();
		this.rol = "IM";
	}

	public ArrayList<String> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(ArrayList<String> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
