package clases.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import clases.remuneracion.Remuneracion;
import clases.repositorios.RemuneracionRepositorio;

public class ServicioRemuneracionImplementacion implements ServicioRemuneracion {
	
	@Autowired
	private RemuneracionRepositorio remuRepo;
	
	@Override
	public Remuneracion crearRemuneracion(Remuneracion nuevaRemuneracion) {
		return remuRepo.save(nuevaRemuneracion);
	}

	@Override
	public void eliminarRemuneracion(long id) {
		remuRepo.deleteById(id);
	}

	@Override
	public Remuneracion modificarRemuneracion(Remuneracion remuneracionAct) {
		return remuRepo.save(remuneracionAct);
	}

	@Override
	public Remuneracion buscarRemuneracion(long id) {
		return remuRepo.findById(id);
	}
	
}
