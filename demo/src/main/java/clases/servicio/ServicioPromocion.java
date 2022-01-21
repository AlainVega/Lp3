package clases.servicio;
import java.util.ArrayList;

public interface ServicioPromocion {

	public Promocion crearPromocion(Promocion promo);
	public void eliminarPromocion(long id);
	public Promocion modificarPromocion(Promocion promo);
	public ArrayList<Promocion> buscarPromocion(String producto);
	public Promocion buscarPromocion(int id);
	
}
