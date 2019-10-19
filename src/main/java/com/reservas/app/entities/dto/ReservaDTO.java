package com.reservas.app.entities.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cantidadPersonas;
	private String descripcion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private int clienteId;
	
	public ReservaDTO() {
		
	}
	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}
	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
