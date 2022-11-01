package com.taller.cliente.repository;



import com.taller.cliente.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<cliente,Integer> {

}
