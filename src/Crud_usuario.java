import java.util.List;

public interface Crud_usuario {
	
	public Usuario crear_usuario();
	public void eliminar_usuario();
	public Usuario modificar_usuario();
	public List<String> buscar_usuario();
	
}
