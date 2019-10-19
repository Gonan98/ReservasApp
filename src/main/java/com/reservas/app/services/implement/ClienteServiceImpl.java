package com.reservas.app.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservas.app.entities.Cliente;
import com.reservas.app.repositories.IClienteRepository;
import com.reservas.app.services.IClienteService;

@Service
@Transactional(readOnly = true)
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional
	public Cliente save(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(t);
	}

	@Override
	@Transactional
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public Optional<Cliente> findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public List<Cliente> findByApellidos(String apellidos) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByApellidos(apellidos);
	}

	@Override
	public Cliente findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByDni(dni);
	}

}
