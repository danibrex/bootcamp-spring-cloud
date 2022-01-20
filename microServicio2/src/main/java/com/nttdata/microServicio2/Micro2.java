package com.nttdata.microServicio2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Micro2 {
	
	@GetMapping("/micro2")
	public String micro2() {
		return "Soy el micro2";
	}

}
