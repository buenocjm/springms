package com.taller.report.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="informeOrdenServicio")
public class InformeOrdenServicio {

   
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdDetalleInforme")
    private Integer IdDetalleInforme;
    
    
    @Column (name ="idcliente")
    private Integer idcliente;
     

    @Column(name = "nroRdenConsultaDetalle", nullable = true, length = 50)

    private String nroRdenConsultaDetalle;

    @Size(min = 3, max = 18, message = "mes en que se realiza el Servicio debe tener minimo 3 caracteres")
    @Column(name = "meServicio", nullable = true, length = 18)
    private String meServicio;


    @Size(min = 4, max = 4, message = "año en que se realiza el Servicio debe tener minimo 4 caracteres")
    @Column(name = "AnioServicio", nullable = true, length = 4)
    private String AnioServicio;


    @Size(min = 10, max = 50, message = "Nombre de quien Realiza el servicio debe tener minimo 10 caracteres")
    @Column(name = "realizadopor", nullable = true, length = 50)
    private String realizadopor;


    @Size(min = 2, max = 20, message = "Fecha de proximo servicio/mantencion debe tener minimo 2 caracteres")
    @Column(name = "fechaProxMantencion", nullable = true, length = 20)
    private String fechaProxMantencion;


    @Size(message = "Observaciones para informe servicio/mantencion debe tener minimo 1 caracteres")
    @Column(name = "observacioneService", nullable = true)
    private String observacioneService;


	public Integer getIdDetalleInforme() {
		return IdDetalleInforme;
	}


	public void setIdDetalleInforme(Integer idDetalleInforme) {
		IdDetalleInforme = idDetalleInforme;
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
