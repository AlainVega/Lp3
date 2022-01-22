package clases.controladores;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clases.invitacion.Invitacion;
import clases.organizacion.Organizacion;
import clases.servicio.ServicioInvitacion;
import clases.servicio.ServicioOrganizacion;
import clases.servicio.ServicioUsuario;
import clases.usuario.AngelInvestor;
import clases.usuario.Brainstormer;
import clases.usuario.Implementador;
import clases.usuario.Sponsor;
import clases.usuario.Usuario;

@RestController
public class Controller {
	
	//Usuarios
	
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
	
	//Organizaciones
	
	@Autowired
	private ServicioOrganizacion servicioOrganizacion;
	
	@PutMapping(
			value = {"/crearOrganizacion", "/actualizarOrganizacion"},
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organizacion crearOrganizacion(@RequestBody Organizacion organizacion) {
		return servicioOrganizacion.crearOrg(organizacion);
	}
	
	@DeleteMapping("/eliminarOrganizacion/{id}")
	public void eliminarOrganizacion(@PathVariable long id) {
		servicioOrganizacion.eliminarOrg(id);
	}
	
	@GetMapping("/listarOrganizaciones/{tipo}")
	public ArrayList<Organizacion> listarOrganizaciones(@PathVariable String tipo) {
		return servicioOrganizacion.listarPorTipo(tipo);
	}
	
	@PostMapping("/agregarMiembro")
	public Organizacion agregarMiembro(@RequestBody Map<String, String> json) {
		return servicioOrganizacion.agregarMiembro(Long.parseLong(json.get("idOrg")), Long.parseLong(json.get("idUsuario")));
	}
	
	// Invitaciones
	
	@Autowired
	private ServicioInvitacion servicioInvitacion;
	
	@PutMapping(
			value = "/crearInvitacion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Invitacion crearInvitacion(@RequestBody Invitacion invitacion) {
		return servicioInvitacion.crearInv(invitacion);
	}
	
	@DeleteMapping("/eliminarInvitacion/{id}")
	public void eliminarInvitacion(@PathVariable long id) {
		servicioInvitacion.eliminarInv(id);
	}
	
	@GetMapping("/aceptarInvitacion/{id}")
	public void aceptarInvitacion(@PathVariable long id) {
		servicioInvitacion.aceptarInvitacion(id);
	}
	
	@GetMapping("/checkearExpiracionInvitaciones")
	public String checkearExpiracionInvitaciones() {
		Integer cantidadExpiradas = servicioInvitacion.checkearExpiracionTodas();
		return String.format("Hay %d invitaciones expiradas.", cantidadExpiradas);
	}
	
}
