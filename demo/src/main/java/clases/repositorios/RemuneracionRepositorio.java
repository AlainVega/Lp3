package clases.repositorios;

import org.springframework.data.repository.CrudRepository;

import clases.remuneracion.Remuneracion;

public interface RemuneracionRepositorio extends CrudRepository<Remuneracion, Long> {
	Remuneracion findById(long id);
}
