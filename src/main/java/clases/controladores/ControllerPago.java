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

import clases.pago.Pago;
import clases.servicio.ServicioPago;

//Controlador para todos los endpoints relacionado a pagos, cada ruta esta enlazada a una funcion dentro de ServicioUsuario

@RestController
public class ControllerPago {

	@Autowired
	private ServicioPago servicioPago;
	
	@PutMapping(
			value = "/crearPago",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Pago crearPago(@RequestBody Pago pago) {
		return servicioPago.crearPago(pago);
	}
	
	@PutMapping(
			value = "/actualizarPago",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Pago actualizarPago(@RequestBody Pago pagoAct) {
		return servicioPago.actualizarPago(pagoAct);
	}
	
	@DeleteMapping("/eliminarPago/{id}")
	public void eliminarPago(@PathVariable long id) {
		servicioPago.eliminarPago(id);
	}
	
	@GetMapping("/listarPagos")
	public ArrayList<Pago> listarPagos(HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/pagos");
		return null;
	}
	
	@GetMapping("/buscarPago/{id}")
	public Pago obtenerPago(@PathVariable long id) {
		return servicioPago.buscarPago(id);
	}

}
