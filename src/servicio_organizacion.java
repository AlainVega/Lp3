import java.util.ArrayList;

public interface servicio_organizacion {

	public Organizacion crear_org(Organizacion nueva_organizacion);
	public void eliminar_org(int id);
	public Organizacion modificar_org(Organizacion organizacion_act);
	public ArrayList<Integer> buscar_org(int id);
	public ArrayList<Integer> buscar_org(String tipo);
	
}
