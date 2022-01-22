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

@Service
public class ServicioOrganizacionImplementacion implements ServicioOrganizacion {
	
	@Autowired
	private OrganizacionRepositorio orgRepo;
	@Autowired
	private UsuarioRepositorio usuarioRepo;

	@Override
	public Organizacion crearOrg(Organizacion nuevaOrganizacion) {
		return orgRepo.save(nuevaOrganizacion);
	}

	@Override
	public void eliminarOrg(long id) {
		try {
			orgRepo.deleteById(id);
		}
		catch (Exception e) {
			System.out.println("La organizacion no existe.");
		}
			
	}

	@Override
	public Organizacion modificarOrg(Organizacion organizacionAct) {
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
		if (!usuarioRepo.existsById(idUsuario)) {
			System.out.println("El usuario no existe.");
		}
		else {
			Optional<Usuario> usuarioOpt = usuarioRepo.findById(idUsuario);
			Usuario usuario = usuarioOpt.get();
			if (Objects.equals(usuario.getRol(), "AI") && (org.listaUsuarios.size() < 2)) {
				System.out.println("El Angel Investor solo puede agregarse a organizaciones que tengan 2 miembros o mas.");
			}
			else {
				org.listaUsuarios.add(idUsuario);
			}
		}
		return orgRepo.save(org);
	}
}
