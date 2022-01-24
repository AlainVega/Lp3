package clases.servicio;
import java.util.ArrayList;

import clases.usuario.Administrador;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

public interface ServicioUsuario {
	
	public Administrador crearAdministrador(Administrador administrador);
	public AngelInvestor crearAngelInvestor(AngelInvestor nuevoBrainstormer);
	public Brainstormer crearBrainstormer(Brainstormer nuevoBrainstormer);
	public Implementador crearImplementador(Implementador nuevoImplementador);
	public Sponsor crearSponsor(Sponsor sponsor);
	
	public Administrador actualizarAdministrador(Administrador administradorAct);
	public AngelInvestor actualizarAngelInvestor(AngelInvestor angelInvestorAct);
	public Brainstormer actualizarBrainstormer(Brainstormer brainstormerAct);
	public Implementador actualizarImplementador(Implementador implementadorAct);
	public Sponsor actualizarSponsor(Sponsor sponsorAct);
	
	public void eliminarUsuario(long id);
	
	public ArrayList<Usuario> listarPorRol(String rol);
	
}
