package com.nttdata.springCloudactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {
	
	private Counter counter;
	
	//introduce en las metricas este endpoint para monitoreo en prometheus/grafana
	public TestController(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.hello").description("invocaciones totales").register(registry);		
	}
	
	@GetMapping(path="/helloworld")
	public String helloworld() {
		//incrementa el contador y muestra el dato en las metricas junto la descripcion de arriba
		counter.increment();
		return "Hello world";
	}
	

}
