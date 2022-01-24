package clases.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.organizacion.Organizacion;

//Interfaz del repositorio para las organizaciones, que se utiliza en las implementaciones de los servicios de las mismas.

@Repository
@RepositoryRestResource(collectionResourceRel = "organizaciones", path = "organizaciones")
public interface OrganizacionRepositorio extends CrudRepository<Organizacion, Long> {
	ArrayList<Organizacion> findByTipo(String tipo);
}
