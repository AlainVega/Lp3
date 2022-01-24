package clases.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.remuneracion.Remuneracion;
import clases.remuneracion.RemuneracionImpuesto;
import clases.repositorios.RemuneracionRepositorio;

@Service
public class ServicioRemuneracionImplementacion implements ServicioRemuneracion {
	
	@Autowired
	private RemuneracionRepositorio remuRepo;
	
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

	@Override
	public Remuneracion actualizarRemuneracion(Remuneracion remuAct) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(remuAct.getId());
		if (remuOpt.isPresent()) {
			return remuRepo.save(remuOpt.get());
		}
		return null;
	}
	
	@Override
	public Remuneracion actualizarRemuneracionImpuesto(Remuneracion remuImpAct) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(remuImpAct.getId());
		if (remuOpt.isPresent()) {
			return remuRepo.save(remuOpt.get());
		}
		return null;
	}

	@Override
	public Remuneracion buscarRemuneracion(long id) {
		Optional<Remuneracion> remuOpt = remuRepo.findById(id);
		if (remuOpt.isPresent()) {
			return remuOpt.get();
		}
		return null;
	}
	
}
