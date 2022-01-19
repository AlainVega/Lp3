package clases.servicio;
import java.util.List;

import clases.remuneracion.Remuneracion;

public interface ServicioPago {

	public Remuneracion crearRemuneracion(Remuneracion nuevaRemuneracion);
	public void eliminarRemuneracion(long id);
	public Remuneracion modificarRemuneracion(Remuneracion remuneracionAct);
	public Remuneracion buscarRemuneracion(long id);
}
