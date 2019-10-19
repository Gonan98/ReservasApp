package com.reservas.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.app.entities.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Integer>{
	
	public List<Reserva> findByFechaIngresoBetween(Date fechaInicio, Date fechaFin);
}
