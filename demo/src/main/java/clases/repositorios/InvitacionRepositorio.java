package clases.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.invitacion.Invitacion;

@Repository
@RepositoryRestResource(collectionResourceRel = "invitaciones", path = "invitaciones")
public interface InvitacionRepositorio extends CrudRepository<Invitacion, Long> {
}
