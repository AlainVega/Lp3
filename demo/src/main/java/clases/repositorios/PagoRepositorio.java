package clases.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.pago.Pago;

@Repository
@RepositoryRestResource(collectionResourceRel = "pagos", path = "pagos")
public interface PagoRepositorio extends CrudRepository<Pago, Long> {
}
