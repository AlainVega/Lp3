package clases.servicio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.invitacion.Invitacion;
import clases.repositorios.InvitacionRepositorio;
import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

//Implementacion del servicio invitacion, para el uso del crud.

//Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioInvitacionImplementacion implements ServicioInvitacion {
	
	@Autowired
	private InvitacionRepositorio invRepo;		//Instancia del repositorio invitacion, para la utilizacion de metodos crud.
	@Autowired
	private UsuarioRepositorio usuarioRepo;		//Instancia del repositorio usuario, se utiliza en aceptar invitacion.
	
	@Override
	public Invitacion crearInv(Invitacion nuevaInvitacion) {
		return invRepo.save(nuevaInvitacion);
	}

	@Override
	public void eliminarInv(long id) {
		invRepo.deleteById(id);
	}

	@Override
	public Invitacion modificarInv(Invitacion invitacionAct) {
		return invRepo.save(invitacionAct);
	}

	@Override
	public Integer checkearExpiracionTodas() {
		Iterable<Invitacion> invitaciones = invRepo.findAll();
		LocalDate todayDate = LocalDate.now();
		Integer contador = 0;
		for (Invitacion inv: invitaciones) {	//Recorremos todas las invitaciones existentes.
			if ((todayDate.isBefore(inv.getFechaCreacion()) || todayDate.isAfter(inv.getFechaExpiracion()))) {		//Si la invitacion expiro, imprimimos un mensaje en consola.
				System.out.println(String.format("La invitacion #%d expiro.", inv.getId()));
				contador++;																							//contabilizamos la invitacuion expirada.
				inv.setExpirado(true);
			}
			else {
				inv.setExpirado(false);
			}
			invRepo.save(inv);
		}
		return contador;		// retorna la cantidad de invitaciones que expiraron.
	}

	@Override
	public void aceptarInvitacion(long id) {																		
		Invitacion invitacion = invRepo.findById(id);	//Instanciamos la invitacion, dada su id
		Optional<Usuario> usuarioOptional = usuarioRepo.findById(invitacion.getIdParaUsuario());
		Usuario usuario = usuarioOptional.get();
		if (usuario != null) {			//Si el usuario existe, entonces se le asigna su membresia.
			usuario.setMembresiaFechaInicio(LocalDate.now());
			usuario.setMembresiaFechaExpiracion(LocalDate.now().plusDays(30));
			usuarioRepo.save(usuario);	//guardamos lo actualizado.
		}
		else {
			System.out.println("Usuario no encontrado.");
		}
	}
	
}
