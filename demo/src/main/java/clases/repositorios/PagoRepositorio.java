package clases.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.pago.Pago;

//Interfaz del repositorio para los pagos, que se utiliza en las implementaciones de los servicios de los mismos.

@Repository
@RepositoryRestResource(collectionResourceRel = "pagos", path = "pagos")
public interface PagoRepositorio extends CrudRepository<Pago, Long> {
}
