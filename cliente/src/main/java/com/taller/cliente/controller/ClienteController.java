package com.taller.cliente.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.taller.cliente.model.cliente;
import com.taller.cliente.model.reportm;
import com.taller.cliente.service.ClienteService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

   
    private final ClienteService clienteService;
    
    @Autowired
    public ClienteController(ClienteService clienteService) {
    	this.clienteService = clienteService;
	
    }

    @GetMapping
    public List<cliente> findAll(){
        return  clienteService.findAll();
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<cliente> obtenercliente(@PathVariable("id") int id) {
		cliente client = clienteService.getClienteById(id);
		if (client == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(client);
	}

	@CircuitBreaker(name = "cirBreports", fallbackMethod = "fallBackReports")
    @GetMapping("/informeorden")
    public ResponseEntity<List<reportm>> getReportsMS () {   	
        List<reportm> lista = clienteService.getReportsAll();
        return new ResponseEntity<List<reportm>>(lista, HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> fallBackReports(RuntimeException exception) {
		return new ResponseEntity("los datos de Informes para este cliente no estan disponibles",
				HttpStatus.NOT_FOUND);
	}
	
    @PostMapping
    public cliente save(@RequestBody cliente clientCurrent){
        return clienteService.save(clientCurrent);
    }
    
    
    
    
    
}
