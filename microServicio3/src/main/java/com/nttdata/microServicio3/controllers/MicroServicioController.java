package com.nttdata.microServicio3.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microServicio3.util.GetUrls;

@CrossOrigin(origins = {"*"})
@RestController
public class MicroServicioController {
	
	@GetMapping("/respuesta")
	public List<String> actuator() throws IOException{
		try {
			return GetUrls.buscarUrls();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GetUrls.buscarUrls();
	}
	
}
