package com.taller.cliente.controller;

import java.util.List;

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

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GetMapping("/informeorden")
    public ResponseEntity<List<reportm>> getReportsMS () {
    	//cliente Cliente = clienteService.leerPorId(idCliente);
    	//if (Cliente == null) {
    		//return ResponseEntity.notFound().build();
    	//}
    	
        List<reportm> lista = clienteService.getReportsAll();
        return new ResponseEntity<List<reportm>>(lista, HttpStatus.OK);
    }

    @SuppressWarnings("unused")
	private ResponseEntity<List<reportm>> fallbackMethod() {
    	//	tracer.currentSpan().tag("error", "No esta disponible informe orden");
    		return ResponseEntity.notFound().build();
    	}   
	
    @PostMapping
    public cliente save(@RequestBody cliente clientCurrent){
        return clienteService.save(clientCurrent);
    }
    
    
    
}
