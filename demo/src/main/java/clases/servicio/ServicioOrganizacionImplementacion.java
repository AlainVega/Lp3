package clases.servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clases.organizacion.Organizacion;
import clases.repositorios.OrganizacionRepositorio;

@Service
public class ServicioOrganizacionImplementacion implements ServicioOrganizacion {
	
	@Autowired
	private OrganizacionRepositorio orgRepo;

	@Override
	public Organizacion crearOrg(Organizacion nuevaOrganizacion) {
		return orgRepo.save(nuevaOrganizacion);
	}

	@Override
	public void eliminarOrg(long id) {
		try {
			orgRepo.deleteById(id);
		}
		catch (Exception e) {
			System.out.println("xd");
		}
			
	}

	@Override
	public Organizacion modificarOrg(Organizacion organizacionAct) {
		return null;
	}

	@Override
	public ArrayList<Organizacion> listarPorTipo(String tipo) {
		return orgRepo.findByTipo(tipo);
	}
}
