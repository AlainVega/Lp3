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

import clases.remuneracion.Remuneracion;
import clases.remuneracion.RemuneracionImpuesto;
import clases.servicio.ServicioRemuneracion;

//Controlador para todos los endpoints relacionado a remuneraciones, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerRemu {

	@Autowired
	private ServicioRemuneracion servicioRemuneracion;
	
	@PutMapping(
			value = "/crearRemuneracion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Remuneracion crearRemuneracion(@RequestBody Remuneracion remu) {
		return servicioRemuneracion.crearRemuneracion(remu);
	}
	
	@PutMapping(
			value = "/crearRemuneracionImpuesto",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public RemuneracionImpuesto crearRemuneracionImpuesto(@RequestBody RemuneracionImpuesto remuImpuesto) {
		return servicioRemuneracion.crearRemuneracionImpuesto(remuImpuesto);
	}
	
	@PutMapping(
			value = "/actualizarRemuneracion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Remuneracion actualizarRemuneracion(@RequestBody Remuneracion remuAct) {
		return servicioRemuneracion.actualizarRemuneracion(remuAct);
	}
	
	@PutMapping(
			value = "/actualizarRemuneracionImpuesto",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Remuneracion actualizarRemuneracionImpuesto(@RequestBody RemuneracionImpuesto remuImpAct) {
		return servicioRemuneracion.actualizarRemuneracionImpuesto(remuImpAct);
	}
	
	@DeleteMapping("/eliminarRemuneracion/{id}")
	public void eliminarRemuneracion(@PathVariable long id) {
		servicioRemuneracion.eliminarRemuneracion(id);
	}
	
	@GetMapping("/buscarRemuneracion/{id}")
	public Remuneracion buscarRemuneracion(@PathVariable long id) {
		return servicioRemuneracion.buscarRemuneracion(id);
	}
	
	@GetMapping("/listarRemuneraciones")
	public ArrayList<Remuneracion> listarRemuneraciones(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/remuneraciones");
		return null;
	}
	
}
