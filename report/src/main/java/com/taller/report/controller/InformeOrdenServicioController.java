package com.taller.report.controller;



import com.taller.report.service.InformeOrdenServicioService;

import com.taller.report.exception.ModelNotFoundException;
import com.taller.report.model.InformeOrdenServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/informeordenservicio")
public class InformeOrdenServicioController {
	
	@Autowired
	private InformeOrdenServicioService informeOrdenServicioService;

 
    public InformeOrdenServicioController(InformeOrdenServicioService informeOrdenServicioService) {
        this.informeOrdenServicioService = informeOrdenServicioService;
    }

    @GetMapping
    public ResponseEntity<List<InformeOrdenServicio>> findAll() {
        List<InformeOrdenServicio> lista = informeOrdenServicioService.findAll();
        return new ResponseEntity<List<InformeOrdenServicio>>(lista, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
  	public ResponseEntity<InformeOrdenServicio> obtenercliente(@PathVariable("id") int id) {
    	InformeOrdenServicio reports = informeOrdenServicioService.getReportsById(id);
  		if (reports == null) {
  			return ResponseEntity.notFound().build();
  		}
  		return ResponseEntity.ok(reports);
  	}

    @GetMapping("/clientes/{idclient}")
 	public ResponseEntity<List<InformeOrdenServicio>> getReportsbyclient(@PathVariable("idclient") int id){
 		List<InformeOrdenServicio> reportsClientall = informeOrdenServicioService.byIdcliente(id);
 		if(reportsClientall.isEmpty()) {
 			return ResponseEntity.noContent().build();
 		}
 		return ResponseEntity.ok(reportsClientall);
 	
    }
    

    @PostMapping
    public InformeOrdenServicio save(@RequestBody InformeOrdenServicio informeOrdenServicioCurrent){
        return informeOrdenServicioService.save(informeOrdenServicioCurrent);
    }


 


    @PutMapping("/{id}")
    public InformeOrdenServicio update(@RequestBody InformeOrdenServicio informeOrdenServicio, @PathVariable("id") Integer id){
        return informeOrdenServicioService.modificar(informeOrdenServicio);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<InformeOrdenServicio> delete(@PathVariable("id") Integer id) {
        InformeOrdenServicio obj = informeOrdenServicioService.leerPorId(id);


                if (obj.getIdDetalleInforme() == null) {
                    throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
                }else{
                    informeOrdenServicioService.eliminar(id);
                    return new ResponseEntity<InformeOrdenServicio>(obj,HttpStatus.OK);
                }



    }





}
