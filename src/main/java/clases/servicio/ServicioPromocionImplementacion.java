package clases.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.promocion.Promocion;

import clases.repositorios.PromocionRepositorio;

// Se marca como servicio a la clase, para el posterior escano de componentes en el archivo Lp3TpfApplication.java
@Service
public class ServicioPromocionImplementacion implements ServicioPromocion {

	@Autowired
	private PromocionRepositorio promoRepo;	// Instancia del repositorio de promociones
	
	// Crea una entrada en la base de datos con los datos de promo
	@Override
	public Promocion crearPromocion(Promocion promo) {
		return promoRepo.save(promo);
	}

	@Override
	public void eliminarPromocion(long id) {
		if (promoRepo.existsById(id)) {
			promoRepo.deleteById(id);
		}
	}

	// Actualiza la entrada en la base de datos con los datos de promoAct
	@Override
	public Promocion actualizarPromocion(Promocion promoAct) {
		Optional<Promocion> promoOpt = promoRepo.findById(promoAct.getId());
		if (promoOpt.isPresent()) {
			return promoRepo.save(promoAct);
		}
		return null;
	}

	// Retorna una lista de todas las promociones que tengan el mismo producto
	@Override
	public ArrayList<Promocion> buscarPromocion(String producto) {
		return promoRepo.findByProducto(producto);
	}

	// Retorna una instancia de promocion con la id pasada de la base de datos si existe
	@Override
	public Promocion buscarPromocion(long id) {
		Optional<Promocion> promoOpt = promoRepo.findById(id);
		if (promoOpt.isPresent()) {
			return promoOpt.get();
		}
		return null;
	}

}
