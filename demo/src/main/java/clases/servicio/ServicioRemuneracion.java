package clases.servicio;

import clases.remuneracion.Remuneracion;
import clases.remuneracion.RemuneracionImpuesto;

public interface ServicioRemuneracion {

	public Remuneracion crearRemuneracion(Remuneracion nuevaRemuneracion);
	public Remuneracion actualizarRemuneracionImpuesto(Remuneracion remuImpAct);
	public RemuneracionImpuesto crearRemuneracionImpuesto(RemuneracionImpuesto nuevaRemuneracionImpuesto);
	public void eliminarRemuneracion(long id);
	public Remuneracion actualizarRemuneracion(Remuneracion remuneracionAct);
	public Remuneracion buscarRemuneracion(long id);
}
