package clases.servicio;
import java.util.List;

import clases.renumeracion.Remuneracion;

public interface ServicioPago {

	public Remuneracion CrearPago(Remuneracion nuevoPago);
	public void EliminarPago(int id);
	public Remuneracion ModificarPago(Remuneracion pagoAct);
	public List<String> BuscarPago(int id);
	public List<String> BuscarPago(String tipo);
	
}
