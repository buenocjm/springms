package com.taller.composerms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taller.composerms.service.composerservice;


@RestController
@RequestMapping(value = "/allreports")
public class composerController {
	@Autowired
    private composerservice ComposerService;
	
	
	@GetMapping("/{idclient}")
	public ResponseEntity<Map<String, Object>> listarOrdenes(@PathVariable("idclient") int idclient) {
		Map<String, Object> result = ComposerService.getReportsXClient(idclient);
		return ResponseEntity.ok(result);
		
		
		
	}


}
