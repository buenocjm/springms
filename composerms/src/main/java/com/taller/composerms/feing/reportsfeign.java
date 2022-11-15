package com.taller.composerms.feing;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.taller.composerms.model.reportscomposer;


@FeignClient (name="MSREPORTS")


public interface reportsfeign {

	@GetMapping ("/informeordenservicio/clientes/{id}")
	public List<reportscomposer> getReportsComposer(@PathVariable ("id") int idclient);
}
