package clases.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import clases.usuario.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	Usuario findById(@Param("id") Integer id);
}