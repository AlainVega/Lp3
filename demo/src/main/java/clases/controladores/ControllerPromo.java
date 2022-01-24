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

import clases.promocion.Promocion;
import clases.servicio.ServicioPromocion;

//Controlador para todos los endpoints relacionado a promociones, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerPromo {

	@Autowired
	private ServicioPromocion servicioPromocion;
	
	@PutMapping(
			value = "/crearPromocion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Promocion crearPromocion(@RequestBody Promocion promocion) {
		return servicioPromocion.crearPromocion(promocion);
	}
	
	@PutMapping(
			value = "/actualizarPromocion",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Promocion actualizarPromocion(@RequestBody Promocion promocionAct) {
		return servicioPromocion.actualizarPromocion(promocionAct);
	}
	
	@DeleteMapping("/eliminarPromocion/{id}")
	public void eliminarPromocion(@PathVariable long id) {
		servicioPromocion.eliminarPromocion(id);
	}
	
	@GetMapping("/listarPromociones")
	public ArrayList<Promocion> listarPromociones(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/promociones");
		return null;
	}
	
	@GetMapping("/listarPromociones/{producto}")
	public ArrayList<Promocion> listarPromociones(@PathVariable String producto) {
		return servicioPromocion.buscarPromocion(producto);
	}
	
	@GetMapping("/buscarPromocion/{id}")
	public Promocion buscarPromocion(@PathVariable long id) {
		return servicioPromocion.buscarPromocion(id);
	}
}
