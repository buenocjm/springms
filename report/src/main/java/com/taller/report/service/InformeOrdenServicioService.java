package com.taller.report.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.report.exception.ModelNotFoundException;
import com.taller.report.model.InformeOrdenServicio;
import com.taller.report.repository.InformeOrdenServicioRepository;

@Service
public class InformeOrdenServicioService {

	
	  private InformeOrdenServicioRepository informeOrdenServicioRepository;

	    @Autowired
	    public InformeOrdenServicioService(InformeOrdenServicioRepository informeOrdenServicioRepository) {
	        this.informeOrdenServicioRepository = informeOrdenServicioRepository;
	    }


	    
	    public List<InformeOrdenServicio> findAll() {
	        return informeOrdenServicioRepository.findAll();
	    }


	    public InformeOrdenServicio leerPorId(Integer id) {
	            Optional<InformeOrdenServicio> informe = informeOrdenServicioRepository.findById(id);

	            if (id != (int)id){
	                throw new ModelNotFoundException ("Error al encontrar al Informe" + id);
	            }
	            if(informe.isPresent()){
	                return informe.get();
	            }else{
	                throw new ModelNotFoundException("Error al encontrar al Informe");
	            }
	    }



	    
	    public InformeOrdenServicio save(InformeOrdenServicio informeOrdenServicioCurrent) {
	        return informeOrdenServicioRepository.save(informeOrdenServicioCurrent);
	    }

	    
	    public InformeOrdenServicio modificar(InformeOrdenServicio obj) {
	        return informeOrdenServicioRepository.save(obj);
	    }

	    
	    public boolean eliminar(Integer id) {
	        informeOrdenServicioRepository.deleteById(id);
	        return true;
	    }


}
