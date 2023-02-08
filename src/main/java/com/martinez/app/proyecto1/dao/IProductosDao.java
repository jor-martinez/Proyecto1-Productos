package com.martinez.app.proyecto1.dao;

import org.springframework.data.repository.CrudRepository;

import com.martinez.app.proyecto1.models.Producto;

public interface IProductosDao extends CrudRepository<Producto, Long> {

}
