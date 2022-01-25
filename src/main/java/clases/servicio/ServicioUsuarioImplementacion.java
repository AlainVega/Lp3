package clases.servicio;

import java.util.ArrayList;
import java.util.Optional;

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
	public Administrador crearAdministrador(Administrador administrador) {
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
	public Administrador actualizarAdministrador(Administrador administradorAct) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(administradorAct.getId());
		if (usuarioOpt.isPresent()) {
			return usuarioRepo.save(administradorAct);
		}
		return null;
	}
	
	@Override
	public AngelInvestor actualizarAngelInvestor(AngelInvestor angelInvestorAct) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(angelInvestorAct.getId());
		if (usuarioOpt.isPresent()) {
			return usuarioRepo.save(angelInvestorAct);
		}
		return null;
	}
	
	@Override
	public Brainstormer actualizarBrainstormer(Brainstormer brainstormerAct) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(brainstormerAct.getId());
		if (usuarioOpt.isPresent()) {
			return usuarioRepo.save(brainstormerAct);
		}
		return null;
	}
	
	@Override
	public Implementador actualizarImplementador(Implementador implementadorAct) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(implementadorAct.getId());
		if (usuarioOpt.isPresent()) {
			return usuarioRepo.save(implementadorAct);
		}
		return null;
	}

	@Override
	public Sponsor actualizarSponsor(Sponsor sponsorAct) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(sponsorAct.getId());
		if (usuarioOpt.isPresent()) {
			return usuarioRepo.save(sponsorAct);
		}
		return null;
	}
	
	@Override
	public ArrayList<Usuario> listarPorRol(String rol) {
		return usuarioRepo.findByRol(rol);
	}
	
	@Override
	public void eliminarUsuario(long id) {
		if (usuarioRepo.existsById(id)) {
			usuarioRepo.deleteById(id);
		}
	}

	@Override
	public Usuario buscarUsuario(long id) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(id);
		if (usuarioOpt.isPresent()) {
			return usuarioOpt.get();
		}
		return null;
	}
	
}
