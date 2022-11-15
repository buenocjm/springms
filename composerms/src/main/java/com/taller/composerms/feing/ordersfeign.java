package com.taller.composerms.feing;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.taller.composerms.model.orderscomposer;

@FeignClient (name="MSORDERS")


public interface ordersfeign {
	
	@GetMapping ("/ordeneservicio/clientes/{idclient}")
	public List<orderscomposer> getOrdersComposer(@PathVariable ("idclient") int idclient);

	
	
}
