package com.taller.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.orders.exception.ModelNotFoundException;
import com.taller.orders.model.OrdenesServicio;
import com.taller.orders.repository.OrdenesServiciorepository;

@Service
public class OrdeneServicioService {

    private OrdenesServiciorepository ordenesServiciorepository = null;

    @Autowired
    public void OrdenesServicioServiceImpl(OrdenesServiciorepository ordenesServiciorepository) {
        this.ordenesServiciorepository = ordenesServiciorepository;
    }


   
    public List<OrdenesServicio> findAll() {
        return ordenesServiciorepository.findAll();
    }


    public OrdenesServicio leerPorId(Integer id) throws ModelNotFoundException {
        Optional<OrdenesServicio> ordenes = ordenesServiciorepository.findById(id);
        if(ordenes.isPresent()){
            return ordenes.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al ordenes");
        }
    }


    
    public OrdenesServicio save(OrdenesServicio ordenesServicioCurrent) {
        return ordenesServiciorepository.save(ordenesServicioCurrent);
    }

    
    public OrdenesServicio modificar(OrdenesServicio obj) {
        return ordenesServiciorepository.save(obj);
    }

    
    public boolean eliminar(Integer id) {
        ordenesServiciorepository.deleteById(id);
        return true;
    }
}