package clases.organizacion;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import clases.usuario.Usuario;
@Entity
//@Table(name = "Organizaciones")
public class Organizacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String tipo;
	public String nombre;
	public ArrayList<Integer> listaUsuarios = new ArrayList<Integer>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Integer> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Integer> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	

}
