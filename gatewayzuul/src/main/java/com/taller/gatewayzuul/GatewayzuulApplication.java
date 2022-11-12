package com.taller.gatewayzuul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.taller.gatewayzuul.filters.filterpost;
import com.taller.gatewayzuul.filters.filterpretime;
import com.taller.gatewayzuul.filters.filterspre;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class GatewayzuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayzuulApplication.class, args);
	}

	@Bean
    public filterspre miPreFiltro() {
        return new filterspre();
    }
	
	@Bean
    public filterpretime miPreFiltro1() {
        return new filterpretime();
    }
	
	

}
