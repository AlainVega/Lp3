package clases.servicio;
import java.util.ArrayList;

import clases.promocion.Promocion;

public interface ServicioPromocion {

	public Promocion crearPromocion(Promocion promo);
	public void eliminarPromocion(long id);
	public Promocion actualizarPromocion(Promocion promo);
	public ArrayList<Promocion> buscarPromocion(String producto);
	public Promocion buscarPromocion(long id);
	
}
