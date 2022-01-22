package clases.servicio;

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
	public Remuneracion crearRemuneracion(Remuneracion nuevaRemuneracion) {
		return remuRepo.save(nuevaRemuneracion);
	}

	@Override
	public RemuneracionImpuesto crearRemuneracionImpuesto(RemuneracionImpuesto nuevaRemuneracionImpuesto) {
		return remuRepo.save(nuevaRemuneracionImpuesto);
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
