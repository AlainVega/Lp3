package clases.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.promocion.Promocion;

@Repository
@RepositoryRestResource(collectionResourceRel = "promociones", path = "promociones")
public interface PromocionRepositorio extends CrudRepository<Promocion, Long> {
	ArrayList<Promocion> findByProducto(String producto);
}
