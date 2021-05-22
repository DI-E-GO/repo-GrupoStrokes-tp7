package ar.edu.unju.fi.tp6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
	
	public List<Cliente> findAll();
	public Optional<Cliente> findById(Long id);
}
