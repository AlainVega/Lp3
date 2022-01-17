package clases.servicio;
import java.util.ArrayList;

public interface ServicioPromocion {

	public Promocion CrearPromocion(Promocion promo);
	public void EliminarPromocion(int id);
	public Promocion ModificarPromocion(Promocion promo);
	public ArrayList<Integer> BuscarPromocion(String producto);
	public ArrayList<Integer> BuscarPromocion(int idOrg);
	
}
