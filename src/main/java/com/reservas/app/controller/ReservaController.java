package com.reservas.app.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reservas.app.entities.Reserva;
import com.reservas.app.services.IReservaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/reservas")
@Api(tags = "Reserva", value = "Servicio Web RESTful de Reservas")
public class ReservaController {

	@Autowired
	private IReservaService reservaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Reservas", notes = "Metodo para listar todos las reservas")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reservas encontradas"),
		@ApiResponse(code = 404, message = "Reservas no encontradas")
	})
	public ResponseEntity<List<Reserva>> findAll(){
		try {
			List<Reserva> reservas = new ArrayList<>();
			reservas = reservaService.findAll();
			return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Reserva>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar Reserva Por Id", notes = "Metodo para buscar un reserva por Id")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reserva encontrada"),
		@ApiResponse(code = 404, message = "Reserva no encontrada")
	})
	public ResponseEntity<Reserva> findById(@PathVariable("id") Integer id){
		try {
			Optional<Reserva> reserva = reservaService.findById(id);
			if(!reserva.isPresent()) {
				
				return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
				
			}
			
			return new ResponseEntity<Reserva>(reserva.get(),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/searchBetweenDates/{fechaInicio}/{fechaFin}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar Reserva Entre Fechas", notes = "Metodo para buscar un reserva entre fechas")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reservas encontradas"),
		@ApiResponse(code = 404, message = "Reservas no encontradas")
	})
	public ResponseEntity<List<Reserva>> findByFechaIngresoBetween(
			@PathVariable("fechaInicio")
			@DateTimeFormat(iso = ISO.DATE)
			Date fechaInicio,
			@PathVariable("fechaFin")
			@DateTimeFormat(iso = ISO.DATE)
			Date fechaFin){
		try {
			List<Reserva> reservas = new ArrayList<>();
			reservas = reservaService.findByFechaIngresoBetween(fechaInicio, fechaFin);
			return new ResponseEntity<List<Reserva>>(reservas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Reserva>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Crear Reservas", notes = "Metodo para crear una reserva")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reserva creada correctamente"),
		@ApiResponse(code = 400, message = "Solicitud de creación inválida")
	})
	public ResponseEntity<Reserva> insertReserva(@Valid @RequestBody Reserva reserva){
		try {
			Reserva reservaNuevo = new Reserva();
			reservaNuevo = reservaService.save(reserva);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(reservaNuevo.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar Reservas", notes = "Metodo para actualizar una reserva")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
		@ApiResponse(code = 404, message = "Solicitud de actualización inválida")
	})
	public ResponseEntity<Reserva> updateReserva(@Valid @RequestBody Reserva reserva){
		try {
			reservaService.save(reserva);
			return new ResponseEntity<Reserva>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar Reservas", notes = "Metodo para eliminar una reserva")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Reserva eliminada correctamente"),
		@ApiResponse(code = 404, message = "Solicitud de eliminación inválida")
	})
	public ResponseEntity<Reserva> deleteReserva(@PathVariable("id") Integer id){
		try {
			Optional<Reserva> reserva = reservaService.findById(id);
			if(!reserva.isPresent())
				return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
			
			reservaService.deleteById(id);
			return new ResponseEntity<Reserva>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Reserva>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
