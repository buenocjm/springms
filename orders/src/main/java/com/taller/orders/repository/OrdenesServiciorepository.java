package com.taller.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.orders.model.OrdenesServicio;

public interface OrdenesServiciorepository extends JpaRepository<OrdenesServicio, Integer>  {

	List<OrdenesServicio> findByIdcliente(int idclient);

}
