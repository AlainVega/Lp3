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

import clases.invitacion.Invitacion;
import clases.servicio.ServicioInvitacion;

//Controlador para todos los endpoints relacionado a invitaciones, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerInv {

	@Autowired
	private ServicioInvitacion servicioInvitacion;
	
	@PutMapping(
			value = "/crearInvitacion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Invitacion crearInvitacion(@RequestBody Invitacion invitacion) {
		return servicioInvitacion.crearInv(invitacion);
	}
	
	@PutMapping(
			value = "/actualizaInvitacion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Invitacion actualizarInvitacion(@RequestBody Invitacion invitacionAct) {
		return servicioInvitacion.actualizarInv(invitacionAct);
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
	
	@GetMapping("/listarInvitaciones")
	public ArrayList<Invitacion> listarInvitaciones(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/invitaciones");
		return null;
	}
	
	@GetMapping("/buscarInvitacion/{id}")
	public Invitacion buscarInvitacion(@PathVariable long id) {
		return servicioInvitacion.buscarInvitacion(id);
	}

}
