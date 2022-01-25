package clases.controladores;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clases.servicio.ServicioUsuario;
import clases.usuario.Administrador;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

// Controlador para todos los endpoints relacionado a usuarios, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerUsuario {
	
	// Usuarios
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@PutMapping(
			value = "/crearUsuario/administrador",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearAdministrador(@RequestBody Administrador administrador) {
		return servicioUsuario.crearAdministrador(administrador);
	}
	
	@PutMapping(
			value = "/crearUsuario/angelInvestor",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearAngelInvestor(@RequestBody AngelInvestor angelInvestor) {
		return servicioUsuario.crearAngelInvestor(angelInvestor);
	}
	
	@PutMapping(
			value = "/crearUsuario/brainstormer",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearBrainstormer(@RequestBody Brainstormer brainstormer) {
		return servicioUsuario.crearBrainstormer(brainstormer);
	}
	
	@PutMapping(
			value = "/crearUsuario/implementador",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearImplementador(@RequestBody Implementador implementador) {
		return servicioUsuario.crearImplementador(implementador);
	}
	
	@PutMapping(
			value = "/crearUsuario/sponsor",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario CrearSponsor(@RequestBody Sponsor sponsor) {
		return servicioUsuario.crearSponsor(sponsor);
	}
	
	@PutMapping(
			value = "/actualizarAdministrador",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarAdministrador(@RequestBody Administrador administrador) {
		return servicioUsuario.actualizarAdministrador(administrador);
	}
	
	@PutMapping(
			value = "/actualizarAngelInvestor",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarAngelInvestor(@RequestBody AngelInvestor angelInvestor) {
		return servicioUsuario.actualizarAngelInvestor(angelInvestor);
	}
	
	@PutMapping(
			value = "/actualizarBrainstormer",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarBrainstormer(@RequestBody Brainstormer brainstormer) {
		return servicioUsuario.actualizarBrainstormer(brainstormer);
	}
	
	@PutMapping(
			value = "/actualizarImplementador",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarImplementador(@RequestBody Implementador implementador) {
		return servicioUsuario.actualizarImplementador(implementador);
	}
	
	@PutMapping(
			value = "/actualizarSponsor",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuario actualizarSponsor(@RequestBody Sponsor sponsor) {
		return servicioUsuario.actualizarSponsor(sponsor);
	}
	
	@GetMapping("/listarUsuarios")
	public ArrayList<Usuario> listarUsuarios(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/usuarios");
		return null;
	}
	
	@GetMapping("/listarUsuarios/{rol}")
	public ArrayList<Usuario> listarUsuariosPorRol(@PathVariable String rol, HttpServletResponse httpResponse) throws Exception {
		return servicioUsuario.listarPorRol(rol);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	public void eliminarUsuario(@PathVariable long id) {
		servicioUsuario.eliminarUsuario(id);
	}
	
	@GetMapping("/buscarUsuario/{id}")
	public Usuario buscarUsuario(@PathVariable long id) {
		return servicioUsuario.buscarUsuario(id);
	}
	
	@GetMapping("/checkearMembresia")
	public void checkearMembresia() {
		servicioUsuario.enviarCorreoPorExpirar();
	}
	
}
