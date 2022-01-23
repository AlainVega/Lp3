package clases.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.remuneracion.Remuneracion;

@Repository
@RepositoryRestResource(collectionResourceRel = "remuneraciones", path = "remuneraciones")
public interface RemuneracionRepositorio extends CrudRepository<Remuneracion, Long> {
	Remuneracion findById(long id);
	@Query(value = "select porcentaje_impuesto from Remuneracion r where r.id=:remuId", nativeQuery = true)
    Double getPorcentajeImpuesto(@Param("remuId") Long remuId);
	@Query(value = "select monto_total from Remuneracion x where x.id=:remuId", nativeQuery = true)
    Double getMontoTotal(@Param("remuId") Long remuId);
}
