package clases.servicio;
import java.util.ArrayList;

import clases.usuario.Usuario;

public interface ServicioUsuario {
	
	public Usuario CrearUsuario(Usuario nuevoUsuario);
	public void EliminarUsuario(int id);
	public Usuario ModificarUsuario(Usuario usuarioAct);
	public ArrayList<Integer> BuscarUsuario(int id);
	public ArrayList<Integer> BuscarUsuario(String rol);
	
}
