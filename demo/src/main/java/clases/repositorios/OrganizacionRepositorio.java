package clases.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.organizacion.Organizacion;

@Repository
@RepositoryRestResource(collectionResourceRel = "organizacion", path = "organizacion")
public interface OrganizacionRepositorio extends CrudRepository<Organizacion, Long> {
	Organizacion findById(long id);
	ArrayList<Organizacion> findByTipo(String tipo);
}
