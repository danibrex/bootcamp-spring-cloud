package com.nttdata.microServicio1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Micro1 {
	
	@GetMapping("/micro1")
	public String micro2() {
		return "Soy el micro1";
	}

		
}
