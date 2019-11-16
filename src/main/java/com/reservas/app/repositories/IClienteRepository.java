package com.reservas.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservas.app.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
	public List<Cliente> findByApellidos(String apellidos);
	public Cliente findByDni(String dni);
}
