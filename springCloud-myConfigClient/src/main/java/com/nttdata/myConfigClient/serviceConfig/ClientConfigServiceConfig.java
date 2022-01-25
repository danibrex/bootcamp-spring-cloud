package com.nttdata.myConfigClient.serviceConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@Configuration
@RefreshScope
public class ClientConfigServiceConfig {
	
	@Value("${some.value}") 
	private String name;
	
	//Constructor vacio para tratar de evitar problemas al inyectar, no funciona
	public ClientConfigServiceConfig() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
