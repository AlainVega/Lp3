package clases.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.remuneracion.Remuneracion;
import clases.remuneracion.RemuneracionImpuesto;
import clases.repositorios.RemuneracionRepositorio;

// Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioRemuneracionImplementacion implements ServicioRemuneracion {
	
	@Autowired
	private RemuneracionRepositorio remuRepo;		// Instancia al repositorio de remuneraciones, para poder hacer uso de los metodos de posee.
	
	// Funciones para crear una entrada en la base de datos de los 2 tipos de remuneracion en la base de datos
	@Override
	public Remuneracion crearRemuneracion(Remuneracion nuevaRemu) {
		return remuRepo.save(nuevaRemu);
	}

	@Override
	public RemuneracionImpuesto crearRemuneracionImpuesto(RemuneracionImpuesto nuevaRemuImp) {
		return remuRepo.save(nuevaRemuImp);
	}
	
	@Override
	public void eliminarRemuneracion(long id) {
		if (remuRepo.existsById(id)) {
			remuRepo.deleteById(id);
		}
	}

	// Funciones para actualizar los 2 tipos de remuneracion existentes
	@Override
	public Remuneracion actualizarRemuneracion(Remuneracion remuAct) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(remuAct.getId());
		if (remuOpt.isPresent()) {
			return remuRepo.save(remuAct);
		}
		return null;
	}
	
	@Override
	public Remuneracion actualizarRemuneracionImpuesto(Remuneracion remuImpAct) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(remuImpAct.getId());
		if (remuOpt.isPresent()) {
			return remuRepo.save(remuImpAct);
		}
		return null;
	}

	// Retorna una instancia de remuneracion con la id pasada de la base de datos si existe
	@Override
	public Remuneracion buscarRemuneracion(long id) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(id);
		if (remuOpt.isPresent()) {
			return remuOpt.get();
		}
		return null;
	}
	
}
