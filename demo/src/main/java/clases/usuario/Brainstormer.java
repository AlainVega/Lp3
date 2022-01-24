package clases.usuario;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Brainstormer extends Usuario {

	public String idea;
	
	public Brainstormer() {
		super();
		this.rol = "BR";
	}
	
	//Getter y Setter
	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}
	
}
