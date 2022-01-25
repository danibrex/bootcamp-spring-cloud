package com.everist.bootcamp.productService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everist.bootcamp.productService.config.ProductServiceConfig;
/*
 * La inyeccion de me falla, no se puede obtener la variable name del bean.
 * He probado poniendole anotaciones, constructor vacio pero me temo que es la configuracion.
 */

@RestController
public class ProductController {

	@Value("${server.port}")
	private String port;
	
	//no puedo inyectar, tengo error por eso pongo anotacion Autowired, no funciona	
	private ProductServiceConfig productServiceConfig;
	
    @Autowired
	public ProductController(ProductServiceConfig productServiceConfig) {
		this.productServiceConfig = productServiceConfig;
	}
	
	@GetMapping("/product")
	public String getPort() {
		return "El puerto del micro es " + port;
	}
	
	@GetMapping("/product-name")
	public String getProductName() {
		return "El nombre del producto es " + productServiceConfig.getName();
	}
	
	
	
}
