package com.everist.bootcamp.productService.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;



@Configuration
@RefreshScope
public class ProductServiceConfig {
	
	@Value("${product.product-name}") 
	private String name;
	
	//Constructor vacio para tratar de evitar problemas al inyectar, no funciona
	public ProductServiceConfig() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
