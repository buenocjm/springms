package com.taller.cliente.events;

import java.util.Date;

import com.taller.cliente.model.cliente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class clientevent extends Event<cliente>{
}
