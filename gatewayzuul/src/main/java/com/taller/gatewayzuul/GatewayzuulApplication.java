package com.taller.gatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.taller.gatewayzuul.filter.filterspre;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayzuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayzuulApplication.class, args);
	}

	@Bean
    public filterspre miPreFiltro() {
        return new filterspre();
    }

}
