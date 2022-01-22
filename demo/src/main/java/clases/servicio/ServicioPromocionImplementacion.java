package clases.servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.repositorios.OrganizacionRepositorio;
import clases.repositorios.PromocionRepositorio;

@Service
public class ServicioPromocionImplementacion implements ServicioPromocion {

	@Autowired
	private PromocionRepositorio promoRepo;	
	
	@Override
	public Promocion crearPromocion(Promocion promo) {
		return promoRepo.save(promo);
	}

	@Override
	public void eliminarPromocion(long id) {
		promoRepo.deleteById(id);
	}

	@Override
	public Promocion modificarPromocion(Promocion promo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Promocion> buscarPromocion(String producto) {
		return promoRepo.findByProducto(producto);
	}

	@Override
	public Promocion buscarPromocion(int id) {
		return promoRepo.findById(id);
	}

}
