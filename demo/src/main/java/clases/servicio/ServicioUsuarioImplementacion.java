package clases.servicio;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.repositorios.UsuarioRepositorio;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

@Service
public class ServicioUsuarioImplementacion implements ServicioUsuario {
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) {
		return usuarioRepo.save(nuevoUsuario);
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
	
	// TODO: Arreglar para que sea mas generico, crashea si se le manda una subclase de Usuario.
	@Override
	public Usuario modificarUsuario(Usuario usuarioAct) throws IllegalArgumentException, IllegalAccessException {
		Usuario usuarioEnDb = usuarioRepo.findById(usuarioAct.getId());
		Field[] usuarioEnDbFields = usuarioEnDb.getClass().getDeclaredFields();
		for(Field f : usuarioEnDbFields) {
			f.setAccessible(true);
			Object value1 = f.get(usuarioEnDb);
			Object value2 = f.get(usuarioAct);
			if(value1 != null && value2 != null) {
				if (!Objects.equals(value1, value2)) {
					f.set(usuarioEnDb, value2);
				}
			}
		}
		return usuarioRepo.save(usuarioEnDb);
	}
}
