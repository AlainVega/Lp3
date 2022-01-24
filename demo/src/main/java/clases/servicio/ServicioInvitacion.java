package clases.servicio;

import clases.invitacion.Invitacion;

public interface ServicioInvitacion {
	public Invitacion crearInv(Invitacion nuevaInvitacion);
	public void eliminarInv(long id);
	public Invitacion actualizarInv(Invitacion invitacionAct);
	public int checkearExpiracionTodas();
	public void aceptarInvitacion(long id);
	public Invitacion buscarInvitacion(long id);
}
