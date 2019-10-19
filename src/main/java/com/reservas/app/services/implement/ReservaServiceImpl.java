package com.reservas.app.services.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservas.app.entities.Reserva;
import com.reservas.app.repositories.IReservaRepository;
import com.reservas.app.services.IReservaService;

@Service
@Transactional(readOnly = true)
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaRepository reservaRepository;
	
	@Override
	@Transactional
	public Reserva save(Reserva t) throws Exception {

		return reservaRepository.save(t);
	}

	@Override
	@Transactional
	public void deleteById(int id) throws Exception {
		
		reservaRepository.deleteById(id);
	}

	@Override
	public Optional<Reserva> findById(int id) throws Exception {
		
		return reservaRepository.findById(id);
	}

	@Override
	public List<Reserva> findAll() throws Exception {
		
		return reservaRepository.findAll();
	}

	@Override
	public List<Reserva> findByFechaIngresoBetween(Date fechaInicio, Date fechaFin) {
		
		return reservaRepository.findByFechaIngresoBetween(fechaInicio, fechaFin);
	}

}
