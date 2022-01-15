package clases.servicio;
import java.util.ArrayList;

import clases.usuario.Usuario;

public interface ServicioUsuario {
	
	public Usuario crear_usuario(Usuario nuevo_usuario);
	public void eliminar_usuario(int id);
	public Usuario modificar_usuario(Usuario usuario_act);
	public ArrayList<Integer> buscar_usuario(int id);
	public ArrayList<Integer> buscar_usuario(String rol);
	
}
