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
	
	// Actualiza la entrada con los datos orgAct
	@Override
	public Organizacion actualizarOrg(Organizacion orgAct) {
		Optional<Organizacion> orgOpt = orgRepo.findById(orgAct.getId());
		if (orgOpt.isPresent()) {
			return orgRepo.save(orgAct);
		}
		return null;
	}

	// Retorna una lista de todas las organizaciones que tengan el tipo pedido
	@Override
	public ArrayList<Organizacion> listarPorTipo(String tipo) {
		return orgRepo.findByTipo(tipo);
	}

	// Recibe el id de una org y el de un usuario para agregarlo a su lista de miembros
	// Retorna la instancia de organizacion actualizada
	@Override
	public Organizacion agregarMiembro(Long idOrg, Long idUsuario) {
		Optional<Organizacion> orgOpt = orgRepo.findById(idOrg);
		
		if (orgOpt.isEmpty()) {
			System.out.println("La organizacion no existe");
			return null;
		}
		
		Organizacion org = orgOpt.get();
		if (!usuarioRepo.existsById(idUsuario)) {			// Si el usuario no existe, entonces se imprime un mensaje en la consola
			System.out.println("El usuario no existe.");
			return null;
		}
		else {												
			Optional<Usuario> usuarioOpt = usuarioRepo.findById(idUsuario);
			Usuario usuario = usuarioOpt.get();
			
			// Verificar si el usuario ya forma parte de esta organizacion
			if (org.getListaUsuarios().contains(usuario.getId())) {
				System.out.println("El usuario ya forma parte de esta organizacion.");
			}
			// Si el usuario es un Angel Investor, entonces la organizacion a la cual va a formar parte para financiar, debe tener al menos 2 miembros.
			else if (Objects.equals(usuario.getRol(), "AI") && (org.listaUsuarios.size() < 2)) {		
				System.out.println("El Angel Investor solo puede agregarse a organizaciones que tengan 2 miembros o mas.");
			}
			else if (Objects.equals(usuario.getRol(), "AD")) {
				System.out.println("Los administradores no pueden formar parte de una organizacion.");
			}
			else {
				org.listaUsuarios.add(idUsuario);
			}
		}
		return orgRepo.save(org);
	}

	// Busca una organizacion por id y la devuelve si existe
	@Override
	public Organizacion buscarOrganizacion(long id) {
		Optional<Organizacion> orgOpt = orgRepo.findById(id);
		if (orgOpt.isPresent()) {
			return orgOpt.get();
		}
		return null;
	}
}
