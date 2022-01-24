package clases.servicio;
import java.util.ArrayList;

import clases.organizacion.Organizacion;

public interface ServicioOrganizacion {

	public Organizacion crearOrg(Organizacion nuevaOrganizacion);
	public void eliminarOrg(long id);
	public Organizacion actualizarOrg(Organizacion organizacionAct);
	public ArrayList<Organizacion> listarPorTipo(String tipo);
	public Organizacion agregarMiembro(Long idOrg, Long idUsuario);
	
}
