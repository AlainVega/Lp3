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
	public Invitacion crearInv(Invitacion nuevaInv) {
		return invRepo.save(nuevaInv);
	}

	@Override
	public void eliminarInv(long id) {
		if (invRepo.existsById(id)) {
			invRepo.deleteById(id);
		}
	}

	@Override
	public Invitacion modificarInv(Invitacion invAct) {
		Optional<Invitacion> invOpt = invRepo.findById(invAct.getId());
		if (invOpt.isPresent()) {
			return invRepo.save(invOpt.get());
		}
		return null;
	}

	@Override
	public int checkearExpiracionTodas() {
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
		Optional<Invitacion> invOpt = invRepo.findById(id);
		
		if (invOpt.isEmpty()) {
			System.out.println("No existe la invitacion.");
			return;
		}
			
		Invitacion invitacion = invOpt.get();
		
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(invitacion.getIdParaUsuario());
		
		if (usuarioOpt.isEmpty()) {
			System.out.println("No existe el usuario.");
			return;
		}
		
		Usuario usuario = usuarioOpt.get();
		
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
