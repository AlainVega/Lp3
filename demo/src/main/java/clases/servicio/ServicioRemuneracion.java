package clases.servicio;

import clases.remuneracion.Remuneracion;
import clases.remuneracion.RemuneracionImpuesto;

public interface ServicioRemuneracion {

	public Remuneracion crearRemuneracion(Remuneracion nuevaRemuneracion);
	public RemuneracionImpuesto crearRemuneracionImpuesto(RemuneracionImpuesto nuevaRemuneracionImpuesto);
	public void eliminarRemuneracion(long id);
	public Remuneracion modificarRemuneracion(Remuneracion remuneracionAct);
	public Remuneracion buscarRemuneracion(long id);
}
