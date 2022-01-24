package clases.servicio;

import clases.pago.Pago;

//Interfaz de pagos, con su respectivo crud.
public interface ServicioPago {

	public Pago crearPago(Pago pago);
	public void eliminarPago(long id);
	public Pago modificarPago(Pago pagoAct);
	public Pago buscarPago(long id);
	
}
