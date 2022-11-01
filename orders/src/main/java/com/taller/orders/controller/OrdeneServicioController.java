package com.taller.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping
    public OrdenesServicio save(@RequestBody OrdenesServicio ordenesServicioCurrent){
        return ordeneServicioService.save(ordenesServicioCurrent);
    }
}
