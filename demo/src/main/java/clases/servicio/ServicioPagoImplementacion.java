package clases.servicio;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.organizacion.Organizacion;
import clases.pago.Pago;
import clases.repositorios.OrganizacionRepositorio;
import clases.repositorios.PagoRepositorio;
import clases.repositorios.RemuneracionRepositorio;
import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

@Service
public class ServicioPagoImplementacion implements ServicioPago {

	// Repositorios a ser utilizados
	@Autowired
	private PagoRepositorio pagoRepo;
	
	@Autowired
	private RemuneracionRepositorio remuRepo;
	
	@Autowired
	private OrganizacionRepositorio orgRepo;
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	// Crea una instancia de pago de ser posible y actualiza la capital del usuario y de la organizacion
	// Solo los roles con capacidad de invertir (Angel Investor y Sponsor) pueden hacer un pago
	// Retorna el pago creado
	@Override
	public Pago crearPago(Pago pago) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(pago.getIdUsuario());
		Optional<Organizacion> organizacionOpt = orgRepo.findById(pago.getIdOrganizacion());
		
		if (usuarioOpt.isEmpty()) {
			System.out.println("No existe el usuario.");
			return null;
		}
		
		if (organizacionOpt.isEmpty()) {
			System.out.println("No existe la organizacion.");
			return null;
		}
		
		Usuario usuario = usuarioOpt.get();
		Organizacion organizacion = organizacionOpt.get();
		
		if (Objects.equals(usuario.getRol(), "AI") || Objects.equals(usuario.getRol(), "SP")) {
			long idRemu = pago.getIdRemuneracion();
			double montoRemu = remuRepo.getMontoTotal(idRemu);
			double porcentajeImp;
			
			if (remuRepo.getPorcentajeImpuesto(idRemu) == null) {
				porcentajeImp = 0.0;
			} else {
				porcentajeImp = remuRepo.getPorcentajeImpuesto(idRemu);
			}
			
			pago.setSubTotal(montoRemu);
			double valorImp = montoRemu * (porcentajeImp / 100); // valor numerico del impuesto
			pago.setImpuesto(valorImp);
			double suma = montoRemu + montoRemu * (porcentajeImp / 100);; // sumo el impuesto y el monto
			pago.setTotal(suma);
			
			// Comparar la suma del pago con el capital del usuario
			if (suma <= usuario.getCapital()) {
				
				// Checkear si la organizacion tiene menos de 2 miembros.
				if (Objects.equals(usuario.getRol(), "AI") && organizacion.getListaUsuarios().size() < 2) {
					System.out.println("Los angeles investores solo pueden invertir en organizaciones con mas de 2 miembros.");
					return null;
				}
				usuario.setCapital(usuario.getCapital() - suma);
				organizacion.setCapital(organizacion.getCapital() + suma);
				return pagoRepo.save(pago);
			}
			else {
				System.out.println("El usuario no tiene los fondos necesarios.");
				return null;
			}
		}
		else {
			System.out.println("El usuario no es un rol que puede invertir en una organizacion.");
			return null;
		}
	}
	
	// Otras funciones de utilidad
	
	@Override
	public void eliminarPago(long id) {
		pagoRepo.deleteById(id);
	}

	@Override
	public Pago actualizarPago(Pago pagoAct) {
		Optional<Pago> pagoOpt = pagoRepo.findById(pagoAct.getId());
		if (pagoOpt.isPresent()) {
			return pagoRepo.save(pagoOpt.get());
		}
		return null;
	}

	@Override
	public Pago buscarPago(long id) {
		Optional<Pago> pagoOpt = pagoRepo.findById(id);
		if (pagoOpt.isPresent()) {
			return pagoOpt.get();
		}
		return null;
	}

}
