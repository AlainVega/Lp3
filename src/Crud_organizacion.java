import java.util.List;

public interface Crud_organizacion {

	public Organizacion crear_org();
	public void eliminar_org();
	public Organizacion modificar_org();
	public List<String> buscar_org();
	
}
