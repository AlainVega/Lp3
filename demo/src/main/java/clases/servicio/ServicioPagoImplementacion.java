package clases.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.pago.Pago;
import clases.repositorios.PagoRepositorio;
import clases.repositorios.RemuneracionRepositorio;

@Service
public class ServicioPagoImplementacion implements ServicioPago {

	@Autowired
	private PagoRepositorio pagoRepo;
	
	@Autowired
	private RemuneracionRepositorio remuRepo;
	
	@Override
	public Pago crearPago(Pago pago) {
		long idRemu = pago.getIdRemuneracion();
		double montoRemu = remuRepo.getMontoTotal(idRemu);
		double porcentajeImp;
		if (remuRepo.getPorcentajeImpuesto(idRemu) == null) {
			porcentajeImp = 0.0;
		}else {
			porcentajeImp = remuRepo.getPorcentajeImpuesto(idRemu);
		}
		pago.setSubTotal(montoRemu);
		double valorImp; // valor numerico del impuesto
		valorImp = montoRemu*(porcentajeImp/100);
		pago.setImpuesto(valorImp);
		double suma; // sumo el impuesto y el monto
		suma = montoRemu + montoRemu*(porcentajeImp/100);
		pago.setTotal(suma);
		return pagoRepo.save(pago);
	}

	@Override
	public void eliminarPago(long id) {
		pagoRepo.deleteById(id);
	}

	@Override
	public Pago modificarPago(Pago pagoAct) {
		return null;
	}

	@Override
	public Pago buscarPago(long id) {
		return pagoRepo.findById(id);
	}

}
