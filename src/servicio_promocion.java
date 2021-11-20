import java.util.ArrayList;

public interface servicio_promocion {

	public promocion crear_promocion(promocion promo);
	public void eliminar_promocion(int id);
	public promocion modificar_promocion(promocion promo);
	public ArrayList<Integer> buscar_promocion(String producto);
	public ArrayList<Integer> buscar_promocion(int id_org);
	
}
