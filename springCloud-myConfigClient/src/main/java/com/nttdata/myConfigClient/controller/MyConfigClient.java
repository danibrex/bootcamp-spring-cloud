package com.nttdata.myConfigClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.myConfigClient.serviceConfig.ClientConfigServiceConfig;

@RestController
public class MyConfigClient {
	
	@Value("${some.value}")
	private String configclient;
	
	//no puedo inyectar, tengo error por eso pongo anotacion Autowired, no funciona	
	private ClientConfigServiceConfig clientConfigServiceConfig;
	
    @Autowired
	public MyConfigClient(ClientConfigServiceConfig clientConfigServiceConfig) {
		this.clientConfigServiceConfig = clientConfigServiceConfig;
	}
	
	
	@GetMapping(path="/configclient")
	public String configClient() {
		return configclient;
	}
	
}
