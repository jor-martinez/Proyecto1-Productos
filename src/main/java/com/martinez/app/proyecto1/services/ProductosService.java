package com.martinez.app.proyecto1.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.proyecto1.dao.IProductosDao;
import com.martinez.app.proyecto1.dtos.ProductosCreateDTO;
import com.martinez.app.proyecto1.dtos.ProductosListDTO;
import com.martinez.app.proyecto1.models.Producto;



@Service
public class ProductosService implements IService<ProductosListDTO, ProductosCreateDTO> {

	@Autowired
	private IProductosDao productosDao;;
	
	@Override
	public ProductosListDTO create(ProductosCreateDTO productoDTO) {
		Producto producto = this.dtoToEntity(productoDTO);
		Producto prodNuevo = productosDao.save(producto);
		return this.entityToDto(prodNuevo);
	}
	
	@Override
	public List<ProductosListDTO> findAll() {
		Iterable<Producto> lista = productosDao.findAll();
		List<ProductosListDTO> productos = new ArrayList<>();
		for(Producto p: lista) {
			productos.add(this.entityToDto(p));
		}
		return productos;
		
	}

	@Override
	public ProductosListDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Convierte un dto a una entidad para su tratamiento con la BD
	 * */
	private Producto dtoToEntity(ProductosCreateDTO productoDTO) {
		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setNombre(productoDTO.getNombre());
		producto.setCantidad(productoDTO.getCantidad());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setFechaRegistro(productoDTO.getFechaRegistro());
		producto.setCodigoProducto(productoDTO.getCodigoProducto());
		return producto;
	}
	
	/*
	 * Convierte una entidad  a una entidad para su tratamiento con la BD
	 * */
	private ProductosListDTO entityToDto(Producto producto) {
		ProductosListDTO productoDTO = new ProductosListDTO();
		productoDTO.setId(producto.getId());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setCantidad(producto.getCantidad());
		productoDTO.setDescripcion(producto.getDescripcion());
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(producto.getFechaRegistro());
		productoDTO.setFechaRegistro(stringDate);
		productoDTO.setCodigoProducto(producto.getCodigoProducto());
		return productoDTO;
	}
}
