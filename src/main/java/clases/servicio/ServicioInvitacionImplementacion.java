package clases.servicio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.invitacion.Invitacion;
import clases.repositorios.InvitacionRepositorio;
import clases.repositorios.UsuarioRepositorio;
import clases.usuario.Usuario;

// Implementacion del servicio invitacion, para el uso del crud.

// Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioInvitacionImplementacion implements ServicioInvitacion {
	
	// Repositorios a ser utilizados
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

	// Actualiza la entrada con los datos de invAct y lo retorna
	@Override
	public Invitacion actualizarInv(Invitacion invAct) {
		Optional<Invitacion> invOpt = invRepo.findById(invAct.getId());
		if (invOpt.isPresent()) {
			return invRepo.save(invAct);
		}
		return null;
	}

	// Checkea la expiracion de todas las invitaciones creadas
	// Retorna la cantidad de invitaciones expiradas
	@Override
	public int checkearExpiracionTodas() {
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
	
	// Acepta la invitacion con el id pasado y actualiza la membresia del usuario
	@Override
	public void aceptarInvitacion(long id) {
		// Verificar la existencia del usuario y la invitacion
		Optional<Invitacion> invOpt = invRepo.findById(id);
		
		if (invOpt.isEmpty()) {
			System.out.println("No existe la invitacion.");
			return;
		}
		
		
		// Conseguir el id del usuario para el cual es la invitacion
		Invitacion invitacion = invOpt.get();
		
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(invitacion.getIdParaUsuario());
		
		if (usuarioOpt.isEmpty()) {
			System.out.println("No existe el usuario.");
			return;
		}
		
		Usuario usuario = usuarioOpt.get();
		
		// Calcular las fechas para la membresia y ponerlas al usuario
		if (usuario != null) {
			usuario.setMembresiaFechaInicio(LocalDate.now());
			usuario.setMembresiaFechaExpiracion(LocalDate.now().plusDays(30));
			usuarioRepo.save(usuario);	//guardamos lo actualizado.
		}
		else {
			System.out.println("Usuario no encontrado.");
		}
	}

	// Retorna una instancia de invitacion con la id pasada de la base de datos si existe
	@Override
	public Invitacion buscarInvitacion(long id) {
		Optional<Invitacion> invOpt = invRepo.findById(id);
		if (invOpt.isPresent()) {
			return invOpt.get();
		}
		return null;
	}
	
}
