package com.nttdata.springCloudactuator.customEndPoint;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestControllerEndpoint(id="customEndpoint")
public class CustomEndpoint {
	
	@GetMapping("/random")
	public ResponseEntity<String> customEndpoint() {
		return new ResponseEntity<>("Desde el controlador", HttpStatus.OK);
	}
	

}
