package clases.servicio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.invitacion.Invitacion;
import clases.repositorios.InvitacionRepositorio;
import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

@Service
public class ServicioInvitacionImplementacion implements ServicioInvitacion {
	
	@Autowired
	private InvitacionRepositorio invRepo;
	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
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
		for (Invitacion inv: invitaciones) {
			if ((todayDate.isBefore(inv.getFechaCreacion()) || todayDate.isAfter(inv.getFechaExpiracion()))) {
				System.out.println(String.format("La invitacion #%d expiro.", inv.getId()));
				contador++;
				inv.setExpirado(true);
			}
			else {
				inv.setExpirado(false);
			}
			invRepo.save(inv);
		}
		return contador;
	}

	@Override
	public void aceptarInvitacion(long id) {
		Invitacion invitacion = invRepo.findById(id);
		Optional<Usuario> usuarioOptional = usuarioRepo.findById(invitacion.getIdParaUsuario());
		Usuario usuario = usuarioOptional.get();
		if (usuario != null) {
			usuario.setMembresiaFechaInicio(LocalDate.now());
			usuario.setMembresiaFechaExpiracion(LocalDate.now().plusDays(30));
			usuarioRepo.save(usuario);
		}
		else {
			System.out.println("Usuario no encontrado.");
		}
	}
	
}
