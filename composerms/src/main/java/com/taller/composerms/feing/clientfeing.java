package com.taller.composerms.feing;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.taller.composerms.model.clientecomposer;

@FeignClient (name="MSCLIENTE")

public interface clientfeing {
	@GetMapping ("/cliente/{id}")
	public Optional <clientecomposer> getClientComposer(@PathVariable ("id") int idclient);
	
	
}
