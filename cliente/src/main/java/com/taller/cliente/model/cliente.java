package com.taller.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table (name = "cliente")
//@ApiModel(description = "Información o propiedes del Cliente")
public class cliente {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="idcliente")
    private Integer idcliente;

    @Size(min = 2, message = "Nombres debe tener minimo 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Size(min = 12, message = "las Cuentas deben tener minimo 12 caracteres")
    @Column(name = "cuenta", nullable = false, length = 70)
    private String cuenta;


    @Size(min = 10, max = 13, message = "rut debe tener 10 caracteres")
    @Column(name = "rut", nullable = false, length = 10)
    private String rut;

    @Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
    @Column(name = "direccion", nullable = true, length = 150)
    private String direccion;


    @Size(min = 9, max = 10, message = "Telefono debe tener 9 caracteres")
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;

    @Email
    @Column(name = "email", nullable = true, length = 55)
    private String email;

	public Integer getIdCliente() {
		return idcliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idcliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
