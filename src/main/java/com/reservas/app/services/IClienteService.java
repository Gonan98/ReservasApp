package com.reservas.app.services;

import java.util.List;

import com.reservas.app.entities.Cliente;

public interface IClienteService extends ICrudService<Cliente>{

	public List<Cliente> findByApellidos(String apellidos) throws Exception;
	public Cliente findByDni(String dni) throws Exception;
}
