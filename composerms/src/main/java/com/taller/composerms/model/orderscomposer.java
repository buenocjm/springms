package com.taller.composerms.model;

public class orderscomposer {
	    private Integer IdDetalleServicio;
	    private Integer idcliente;
	    private String nroRden;
	    private String FechaIngress;
	    private String FechaEgress;
	    
		public orderscomposer(Integer idDetalleServicio, Integer idcliente, String nroRden, String fechaIngress,
				String fechaEgress) {
			super();
			IdDetalleServicio = idDetalleServicio;
			this.idcliente = idcliente;
			this.nroRden = nroRden;
			FechaIngress = fechaIngress;
			FechaEgress = fechaEgress;
		}

		public Integer getIdDetalleServicio() {
			return IdDetalleServicio;
		}

		public void setIdDetalleServicio(Integer idDetalleServicio) {
			IdDetalleServicio = idDetalleServicio;
		}

		public Integer getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(Integer idcliente) {
			this.idcliente = idcliente;
		}

		public String getNroRden() {
			return nroRden;
		}

		public void setNroRden(String nroRden) {
			this.nroRden = nroRden;
		}

		public String getFechaIngress() {
			return FechaIngress;
		}

		public void setFechaIngress(String fechaIngress) {
			FechaIngress = fechaIngress;
		}

		public String getFechaEgress() {
			return FechaEgress;
		}

		public void setFechaEgress(String fechaEgress) {
			FechaEgress = fechaEgress;
		}
		
		
	    
	    
}
