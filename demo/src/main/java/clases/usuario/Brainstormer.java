package clases.usuario;

import javax.persistence.Entity;

@Entity
public class Brainstormer extends Usuario {

	public String idea;
	
	public Brainstormer() {
		super();
		this.rol = "BR";
	}
	
	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}
	
}
