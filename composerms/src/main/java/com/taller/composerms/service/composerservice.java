package com.taller.composerms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.composerms.feing.clientfeing;
import com.taller.composerms.feing.ordersfeign;
import com.taller.composerms.feing.reportsfeign;
import com.taller.composerms.model.clientecomposer;
import com.taller.composerms.model.orderscomposer;
import com.taller.composerms.model.reportscomposer;

@Service
public class composerservice {
       
		@Autowired
		private clientfeing ClientFeign;
		
		@Autowired
		private reportsfeign ReportsFeign;
		
		@Autowired
		private ordersfeign OrdersFeign;
	
		public Map<String, Object> getReportsXClient(int idclient){
			Map<String, Object> result = new HashMap<>();
			
			
			  Optional<clientecomposer> client = ClientFeign.getClientComposer(idclient);
			  
			  if(client == null) { result.put("Message", "El cliente no existe"); return
			  result; }
			  
			  result.put("Datos cliente", client);
			 
			 
		
				
			  List<reportscomposer> reports = ReportsFeign.getReportsComposer(idclient);
				  if(reports.isEmpty()) { result.put("Informes Tecnicos",
				  "No existen informes para el cliente"); }else {
				  result.put("Informes Tecnicos", reports); }
				  
				  List<orderscomposer> orders = OrdersFeign.getOrdersComposer(idclient);
				  if(orders.isEmpty()) { result.put("Ordenes de servicio",
				  "No existen ordenes para el cliente"); }else {
				  result.put("Ordenes de servicio", orders); }
				 
			return result;
		}
	
}



