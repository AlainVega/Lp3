package clases.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.promocion.Promocion;

//Interfaz del repositorio para las promoociones, que se utiliza en las implementaciones de los servicios de las mismas.

@Repository
@RepositoryRestResource(collectionResourceRel = "promocion", path = "promocion")
public interface PromocionRepositorio extends CrudRepository<Promocion, Long> {
	Promocion findById(long id);
	ArrayList<Promocion> findByProducto(String producto);
}
