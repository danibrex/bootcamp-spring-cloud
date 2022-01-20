package com.nttdata.gatewayserver;

import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Configuration
@Log4j2
public class Gateway {

	@Bean
	@Order(-1)
	public GlobalFilter a() {
		return (exchange, chain) -> {
			log.info("primer pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("tercer post filter");
			
			}));
		};
	}
	
	@Bean
	@Order(0)
	public GlobalFilter b() {
		return (exchange, chain) -> {
			log.info("segundo pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("segundo post filter");
			
			}));
		};
	}
	
	@Bean
	@Order(1)
	public GlobalFilter c() {
		return (exchange, chain) -> {
			log.info("tercer pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("primer post filter");
			
			}));
		};
	}
	
}
