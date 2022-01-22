package clases.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import clases.usuario.Usuario;

@Repository
@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	Usuario findById(long id);
	ArrayList<Usuario> findByRol(String rol);
	boolean existsById(long id);
}