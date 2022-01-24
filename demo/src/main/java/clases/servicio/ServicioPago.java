package clases.servicio;

import clases.pago.Pago;

public interface ServicioPago {

	public Pago crearPago(Pago pago);
	public void eliminarPago(long id);
	public Pago modificarPago(Pago pagoAct);
	public Pago buscarPago(long id);

}
