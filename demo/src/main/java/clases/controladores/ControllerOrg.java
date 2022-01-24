package clases.controladores;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clases.organizacion.Organizacion;
import clases.servicio.ServicioOrganizacion;

//Controlador para todos los endpoints relacionado a organizaciones, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerOrg {

	@Autowired
	private ServicioOrganizacion servicioOrganizacion;
	
	@PutMapping(
			value = "/crearOrganizacion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organizacion crearOrganizacion(@RequestBody Organizacion organizacion) {
		return servicioOrganizacion.crearOrg(organizacion);
	}
	
	@PutMapping(
			value = "/actualizarOrganizacion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organizacion actualizarOrganizacion(@RequestBody Organizacion organizacionAct) {
		return servicioOrganizacion.actualizarOrg(organizacionAct);
	}
	
	@DeleteMapping("/eliminarOrganizacion/{id}")
	public void eliminarOrganizacion(@PathVariable long id) {
		servicioOrganizacion.eliminarOrg(id);
	}
	
	@GetMapping("/listarOrganizaciones/")
	public ArrayList<Organizacion> listarOrganizaciones(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/organizaciones");
		return null;
	}
	
	@GetMapping("/listarOrganizaciones/{tipo}")
	public ArrayList<Organizacion> listarOrganizaciones(@PathVariable String tipo) {
		return servicioOrganizacion.listarPorTipo(tipo);
	}
	
	@PostMapping("/agregarMiembro")
	public Organizacion agregarMiembro(@RequestBody Map<String, String> json) {
		return servicioOrganizacion.agregarMiembro(Long.parseLong(json.get("idOrg")), Long.parseLong(json.get("idUsuario")));
	}
	
	@GetMapping("/buscarOrganizacion/{id}")
	public Organizacion buscarOrganizacion(@PathVariable long id) {
		return servicioOrganizacion.buscarOrganizacion(id);
	}
}
