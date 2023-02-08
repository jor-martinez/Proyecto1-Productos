package com.martinez.app.proyecto1.dtos;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductosCreateDTO {
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	@Max(1000)
	private Long cantidad;
	@NotNull
	private String descripcion;
	@NotNull
	private Date fechaRegistro;
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{8}", message = "El código debe tener el formato XXX-00000000")
	private String codigoProducto;
	
	public ProductosCreateDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	
}
