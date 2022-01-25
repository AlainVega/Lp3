package clases.servicio;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.organizacion.Organizacion;
import clases.repositorios.OrganizacionRepositorio;
import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

//Implementacion del servicio para el crud de organizaciones

//Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioOrganizacionImplementacion implements ServicioOrganizacion {
	
	@Autowired
	private OrganizacionRepositorio orgRepo; 	//Instancia del repositorio de organizacion, para la utlizacion de metodos crud.
	@Autowired
	private UsuarioRepositorio usuarioRepo;		//Instancia del repositorio de usuario, para su utilizacion en el metodo aagregarMiembro.

	@Override
	public Organizacion crearOrg(Organizacion nuevaOrganizacion) {
		return orgRepo.save(nuevaOrganizacion);
	}

	@Override
	public void eliminarOrg(long id) {
		if (orgRepo.existsById(id)) {
			orgRepo.deleteById(id);
		}
			
	}

	@Override
	public Organizacion actualizarOrg(Organizacion orgAct) {
		Optional<Organizacion> orgOpt = orgRepo.findById(orgAct.getId());
		if (orgOpt.isPresent()) {
			return orgRepo.save(orgOpt.get());
		}
		return null;
	}

	@Override
	public ArrayList<Organizacion> listarPorTipo(String tipo) {
		return orgRepo.findByTipo(tipo);
	}

	@Override
	public Organizacion agregarMiembro(Long idOrg, Long idUsuario) {
		Optional<Organizacion> orgOpt = orgRepo.findById(idOrg);	
		Organizacion org = orgOpt.get();
		if (!usuarioRepo.existsById(idUsuario)) {			//si el usuario no existe, entonces se imprime un mensaje en la consola
			System.out.println("El usuario no existe.");
		}
		else {												
			Optional<Usuario> usuarioOpt = usuarioRepo.findById(idUsuario);
			Usuario usuario = usuarioOpt.get();
			if (Objects.equals(usuario.getRol(), "AI") && (org.listaUsuarios.size() < 2)) {		//Si el usuario es un Angel Investor, entonces la organizacion a la cual va a formar parte para financiar, debe tener al menos 2 miembros.
				System.out.println("El Angel Investor solo puede agregarse a organizaciones que tengan 2 miembros o mas.");
			}
			else {
				org.listaUsuarios.add(idUsuario);
			}
		}
		return orgRepo.save(org);
	}

	@Override
	public Organizacion buscarOrganizacion(long id) {
		Optional<Organizacion> orgOpt = orgRepo.findById(id);
		if (orgOpt.isPresent()) {
			return orgOpt.get();
		}
		return null;
	}
}
