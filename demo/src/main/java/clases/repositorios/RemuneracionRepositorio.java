package clases.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.remuneracion.Remuneracion;

@Repository
@RepositoryRestResource(collectionResourceRel = "remuneraciones", path = "remuneraciones")
public interface RemuneracionRepositorio extends CrudRepository<Remuneracion, Long> {
	Remuneracion findById(long id);
}
