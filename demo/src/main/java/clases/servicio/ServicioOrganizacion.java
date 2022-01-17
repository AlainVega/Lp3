package clases.servicio;
import java.util.ArrayList;

import clases.organizacion.Organizacion;

public interface ServicioOrganizacion {

	public Organizacion CrearOrg(Organizacion nueva_organizacion);
	public void EliminarOrg(int id);
	public Organizacion ModificarOrg(Organizacion organizacionAct);
	public ArrayList<Integer> BuscarOrg(int id);
	public ArrayList<Integer> BuscarOrg(String tipo);
	
}
