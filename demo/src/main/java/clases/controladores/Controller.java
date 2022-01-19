package clases.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clases.servicio.ServicioUsuario;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

@RestController
public class Controller {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@PutMapping(
			value = "/crearUsuario",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearUsuario(@RequestBody Usuario usuario) {
		return servicioUsuario.crearUsuario(usuario);
	}
	
	@PutMapping(
			value = {"/crearUsuario/angelInvestor", "/actualizarUsuario/angelInvestor"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearAngelInvestor(@RequestBody AngelInvestor angelInvestor) {
		return servicioUsuario.crearAngelInvestor(angelInvestor);
	}
	
	@PutMapping(
			value = {"/crearUsuario/brainstormer", "/actualizarUsuario/brainstormer"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearBrainstormer(@RequestBody Brainstormer brainstormer) {
		return servicioUsuario.crearBrainstormer(brainstormer);
	}
	
	
	@PutMapping(
			value = {"/crearUsuario/implementador", "/actualizarUsuario/implementador"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearImplementador(@RequestBody Implementador implementador) {
		return servicioUsuario.crearImplementador(implementador);
	}
	
	@PutMapping(
			value = {"/crearUsuario/sponsor", "/actualizarUsuario/sponsor"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearSponsor(@RequestBody Sponsor sponsor) {
		return servicioUsuario.crearSponsor(sponsor);
	}
	
	@PutMapping(
			value = "/actualizarUsuario",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) throws IllegalArgumentException, IllegalAccessException {
		return servicioUsuario.modificarUsuario(usuario);
	}
	
	// TODO: Agregar que si rol es NULL, se imprimen todos los usuarios
	@GetMapping("/listarUsuarios/{rol}")
	public ArrayList<Usuario> listarUsuariosPorRol(@PathVariable String rol) {
		return servicioUsuario.listarPorRol(rol);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	public void eliminarUsuario(@PathVariable long id) {
		servicioUsuario.eliminarUsuario(id);
	}
}
