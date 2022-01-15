package clases.servicio;
import java.util.ArrayList;

public interface ServicioPromocion {

	public Promocion crear_promocion(Promocion promo);
	public void eliminar_promocion(int id);
	public Promocion modificar_promocion(Promocion promo);
	public ArrayList<Integer> buscar_promocion(String producto);
	public ArrayList<Integer> buscar_promocion(int id_org);
	
}
