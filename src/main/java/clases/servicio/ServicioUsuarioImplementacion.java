package clases.servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

// Implementacion de la interfaz de servicio de los usuarios.

// Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioUsuarioImplementacion implements ServicioUsuario {
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;		// Instancia del repositorio de usuarios, para poder hacer uso de los metodos que posee.
	
	// Funciones para agregar diferentes subclases de Usuario a la base de dato
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

	// Funciones para actualizar todas las subclases de Usuario en la base de datos
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
	
	// Retorna una lista de todos los usuarios que tengan el rol deseado
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

	// Retorna una instancia de usuario con la id pasada de la base de datos si existe
	@Override
	public Usuario buscarUsuario(long id) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(id);
		if (usuarioOpt.isPresent()) {
			return usuarioOpt.get();
		}
		return null;
	}
	
	@Override
	public void enviarCorreoPorExpirar() {
		Iterable<Usuario> usuarios = usuarioRepo.findAll();
		for (Usuario usuario: usuarios) {
			LocalDate finMembresia = usuario.getMembresiaFechaExpiracion();
			long diff = ChronoUnit.DAYS.between(finMembresia, LocalDate.now());
			if (diff <= 7) {
				System.out.println(String.format("La membresia del usuario %d expira en %d dias.", usuario.getId(), diff));
			}
		}
	}
	
}
