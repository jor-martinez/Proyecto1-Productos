package com.martinez.app.proyecto1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.proyecto1.dtos.ProductosCreateDTO;
import com.martinez.app.proyecto1.dtos.ProductosListDTO;
import com.martinez.app.proyecto1.dtos.ResponsesDTO;
import com.martinez.app.proyecto1.services.ProductosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apiProductos/productos")
@CrossOrigin(origins = "*")
public class ProductosController {
	
	Logger logger = Logger.getLogger(ProductosController.class.getName());
	
	@Autowired
	private ProductosService productosService;
	
	@GetMapping
	public List<ProductosListDTO> getProductos() {
		return productosService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<ResponsesDTO> saveProductos(@Valid @RequestBody ProductosCreateDTO productoDTO, BindingResult bindingResults){
		ResponsesDTO respuesta = new ResponsesDTO();
		Map<String, String> errores = new HashMap<>();
		Map<String, String> messages = new HashMap<>();
		if (bindingResults.hasErrors()) {
			for (FieldError error: bindingResults.getFieldErrors()) {
				errores.put(error.getField(), error.getDefaultMessage());
			}
			respuesta.setErrores(errores);
		} else {
			productosService.create(productoDTO);
			messages.put("message", "El producto se registró correctamente");
			respuesta.setMessages(messages);
		}
		logger.info("Errores: "+ bindingResults.toString());
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}
}
