package clases.servicio;
import java.util.ArrayList;

import clases.promocion.Promocion;

//Interfaz de promociones, para su respectivo crud.
public interface ServicioPromocion {

	public Promocion crearPromocion(Promocion promo);
	public void eliminarPromocion(long id);
	public Promocion modificarPromocion(Promocion promo);
	public ArrayList<Promocion> buscarPromocion(String producto);
	public Promocion buscarPromocion(int id);
	
}
