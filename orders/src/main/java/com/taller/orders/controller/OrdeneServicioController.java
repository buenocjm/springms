package com.taller.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.orders.model.OrdenesServicio;
import com.taller.orders.service.OrdeneServicioService;

@RestController
@RequestMapping(value="/ordeneservicio")
public class OrdeneServicioController {

    private final OrdeneServicioService ordeneServicioService;

    @Autowired
    public OrdeneServicioController(OrdeneServicioService ordeneServicioService) {
        this.ordeneServicioService = ordeneServicioService;
    }

    @GetMapping
    public List<OrdenesServicio> findAll(){
        return ordeneServicioService.findAll();
    }
    

    @GetMapping("/{id}")
	public ResponseEntity<OrdenesServicio> obtenerOrdenes(@PathVariable("id") int id) {
    	OrdenesServicio orders = ordeneServicioService.getOrdersById(id);
		if (orders == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(orders);
	}
    
    @GetMapping("/clientes/{idclient}")
	public ResponseEntity<List<OrdenesServicio>> getordersbyclient(@PathVariable("idclient") int id){
		List<OrdenesServicio> orderService = ordeneServicioService.byIdcliente(id);
		if(orderService.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(orderService);
	}

    @PostMapping
    public OrdenesServicio save(@RequestBody OrdenesServicio ordenesServicioCurrent){
        return ordeneServicioService.save(ordenesServicioCurrent);
    }
}
