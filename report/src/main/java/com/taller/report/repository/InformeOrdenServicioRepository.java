package com.taller.report.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.report.model.InformeOrdenServicio;

public interface InformeOrdenServicioRepository extends JpaRepository<InformeOrdenServicio, Integer> {

	List<InformeOrdenServicio> findByIdcliente(int idclient);

}
