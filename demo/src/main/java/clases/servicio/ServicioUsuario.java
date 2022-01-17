package clases.servicio;
import java.util.ArrayList;

import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

public interface ServicioUsuario {
	
	public Usuario crearUsuario(Usuario nuevoUsuario);
	public AngelInvestor crearAngelInvestor(AngelInvestor nuevoBrainstormer);
	public Brainstormer crearBrainstormer(Brainstormer nuevoBrainstormer);
	public Implementador crearImplementador(Implementador nuevoImplementador);
	public Sponsor crearSponsor(Sponsor sponsor);
	public void eliminarUsuario(long id);
	public Usuario modificarUsuario(Usuario usuarioAct) throws IllegalArgumentException, IllegalAccessException;
	public ArrayList<Usuario> listarPorRol(String rol);
}
