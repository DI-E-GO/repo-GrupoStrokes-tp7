package ar.edu.unju.fi.tp6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp6.model.Compra;

public interface ICompraRepository extends CrudRepository<Compra, Long> {

	
	public List<Compra> findAll();
	Optional<Compra> findById(Long id);
}
