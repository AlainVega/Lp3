package clases.organizacion;
import java.util.ArrayList;

import clases.usuario.Usuario;

public class Organizacion {
	
	public int id;
	public String tipo;
	public String nombre;
	public ArrayList<Integer> lista_usuarios = new ArrayList<Integer>();
	
	public void NotificarMiembro(Usuario user) {
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.contains(user.id)) { // verifico si el usuario esta en mi lista de usuarios
				System.out.print("El usuario que posee esta direccion mail: " + user.correo + "/nSe le notifica que su membresia ya expiro");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public ArrayList<Integer> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(ArrayList<Integer> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}
	

}
