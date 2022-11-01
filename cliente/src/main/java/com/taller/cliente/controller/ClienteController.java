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


    @GetMapping("/informeorden/{id}")
    public ResponseEntity<List<reportm>> getReportsMS (@PathVariable("id") int idCliente) {
    	cliente Cliente = clienteService.leerPorId(idCliente);
    	if (Cliente == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
        List<reportm> lista = clienteService.getReportsAll(idCliente);
        return new ResponseEntity<List<reportm>>(lista, HttpStatus.OK);
    }

	
    @PostMapping
    public cliente save(@RequestBody cliente clientCurrent){
        return clienteService.save(clientCurrent);
    }
    
    
    
}
