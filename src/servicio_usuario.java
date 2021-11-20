import java.util.ArrayList;

public interface servicio_usuario {
	
	public Usuario crear_usuario(Usuario nuevo_usuario);
	public void eliminar_usuario(int id);
	public Usuario modificar_usuario(Usuario usuario_act);
	public ArrayList<Integer> buscar_usuario(int id);
	public ArrayList<Integer> buscar_usuario(String rol);
	
}
