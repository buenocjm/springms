package com.taller.cliente.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.taller.cliente.exception.ModelNotFoundException;
import com.taller.cliente.model.cliente;
import com.taller.cliente.model.reportm;
import com.taller.cliente.repository.ClienteRepository;

@Service
public class ClienteService  {

    private ClienteRepository clienteRepository = null;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
	private EurekaClient eureka;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
    
    @Autowired
    public void ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<cliente> findAll() {
        return clienteRepository.findAll();
    }


    public cliente save(cliente clientCurrent) {
        return clienteRepository.save(clientCurrent);
    }

 
    public cliente modificar(cliente obj) {
        return clienteRepository.save(obj);
    }


    public boolean eliminar(Integer id) {
        clienteRepository.deleteById(id);
        return true;
    }


    public cliente leerPorId(Integer id) {
        Optional<cliente> client = clienteRepository.findById(id);
        if(client.isPresent()){
            return client.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al cliente");
        } 
    }
    

	@SuppressWarnings("unchecked")
	public List<reportm> getReportsAll(){
		URI catalogoURI = eureka.getUri("MSGATEWAYZUUL");
		List<reportm> reportsAll = restTemplate.getForObject("http://"+catalogoURI.getHost()+":"+catalogoURI.getPort()+"/inform/informeordenservicio", List.class);
				return reportsAll;
	}

    
    

}
