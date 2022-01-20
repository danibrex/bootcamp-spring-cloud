package com.nttdata.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${product.product-name}")
	private String myvalue;
	
	@GetMapping(path="/myvalue")
	public String value(){
		return this.myvalue;
	}

}
