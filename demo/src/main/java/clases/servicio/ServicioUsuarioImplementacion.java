package clases.servicio;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Administrador;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

//Implementacion de la interfaz de servicio de los usuarios.

//Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioUsuarioImplementacion implements ServicioUsuario {
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;		//Instancia del repositorio de usuarios, para poder hacer uso de los metodos que posee.
	
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) {
		return usuarioRepo.save(nuevoUsuario);
	}

	@Override
	public Usuario crearAdministrador(Administrador administrador) {
		return usuarioRepo.save(administrador);
	}
	
	@Override
	public AngelInvestor crearAngelInvestor(AngelInvestor nuevoAngelInvestor) {
		return usuarioRepo.save(nuevoAngelInvestor);
	}
	
	@Override
	public Brainstormer crearBrainstormer(Brainstormer nuevoBrainstormer) {
		return usuarioRepo.save(nuevoBrainstormer);
	}

	@Override
	public Implementador crearImplementador(Implementador nuevoImplementador) {
		return usuarioRepo.save(nuevoImplementador);
	}

	@Override
	public Sponsor crearSponsor(Sponsor nuevoSponsor) {
		return usuarioRepo.save(nuevoSponsor);
	}

	@Override
	public ArrayList<Usuario> listarPorRol(String rol) {
		return usuarioRepo.findByRol(rol);
	}
	
	@Override
	public void eliminarUsuario(long id) {
		usuarioRepo.deleteById(id);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuarioAct) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
