package com.taller.composerms.model;

public class reportscomposer {
    private Integer idcliente;
    private String nroRdenConsultaDetalle;
    private String meServicio;
    private String AnioServicio;
    private String realizadopor;
    private String fechaProxMantencion;
    private String observacioneService;
    
	public reportscomposer(Integer idcliente, String nroRdenConsultaDetalle, String meServicio, String anioServicio,
			String realizadopor, String fechaProxMantencion, String observacioneService) {
		super();
		this.idcliente = idcliente;
		this.nroRdenConsultaDetalle = nroRdenConsultaDetalle;
		this.meServicio = meServicio;
		AnioServicio = anioServicio;
		this.realizadopor = realizadopor;
		this.fechaProxMantencion = fechaProxMantencion;
		this.observacioneService = observacioneService;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNroRdenConsultaDetalle() {
		return nroRdenConsultaDetalle;
	}

	public void setNroRdenConsultaDetalle(String nroRdenConsultaDetalle) {
		this.nroRdenConsultaDetalle = nroRdenConsultaDetalle;
	}

	public String getMeServicio() {
		return meServicio;
	}

	public void setMeServicio(String meServicio) {
		this.meServicio = meServicio;
	}

	public String getAnioServicio() {
		return AnioServicio;
	}

	public void setAnioServicio(String anioServicio) {
		AnioServicio = anioServicio;
	}

	public String getRealizadopor() {
		return realizadopor;
	}

	public void setRealizadopor(String realizadopor) {
		this.realizadopor = realizadopor;
	}

	public String getFechaProxMantencion() {
		return fechaProxMantencion;
	}

	public void setFechaProxMantencion(String fechaProxMantencion) {
		this.fechaProxMantencion = fechaProxMantencion;
	}

	public String getObservacioneService() {
		return observacioneService;
	}

	public void setObservacioneService(String observacioneService) {
		this.observacioneService = observacioneService;
	}
	
	
    
    
}
