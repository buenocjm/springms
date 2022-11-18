package com.taller.notificationsms.model;



public class cliente {

    private Integer idcliente;
    private String nombre;
    private String cuenta;
    private String rut;
    private String direccion;
    private String telefono;
    private String email;
    
	public cliente(Integer idcliente, String nombre, String cuenta, String rut, String direccion, String telefono,
			String email) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.cuenta = cuenta;
		this.rut = rut;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
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
