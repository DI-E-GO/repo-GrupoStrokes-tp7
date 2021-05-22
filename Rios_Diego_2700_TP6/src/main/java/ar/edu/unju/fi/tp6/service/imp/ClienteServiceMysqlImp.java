package ar.edu.unju.fi.tp6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.repository.IClienteRepository;
import ar.edu.unju.fi.tp6.service.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceMysqlImp implements IClienteService{
	
	@Autowired
	IClienteRepository clienteRepository;


	@Override
	public void addCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@Override
	public void generateTableClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Cliente> getCliente(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
