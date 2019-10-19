package com.reservas.app.services;

import java.util.Date;
import java.util.List;

import com.reservas.app.entities.Reserva;

public interface IReservaService extends ICrudService<Reserva>{

	public List<Reserva> findByFechaIngresoBetween(Date fechaInicio, Date fechaFin);
}
