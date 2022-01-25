package clases.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Implementador extends Usuario {

	public ArrayList<String> asignaciones;		//Lista con las diferentes actividades que se le asocial al implementador.
	
	public Implementador() {
		super();
		this.rol = "IM";
	}

	//Getter y Setter
	public ArrayList<String> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(ArrayList<String> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
