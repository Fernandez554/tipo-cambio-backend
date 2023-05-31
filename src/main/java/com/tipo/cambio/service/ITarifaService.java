package com.tipo.cambio.service;

import com.tipo.cambio.model.Tarifa;


public interface ITarifaService extends ICRUD<Tarifa, Long> {

	Tarifa buscarPorCodMoneda(String codMoneda) throws Exception;
	
}
