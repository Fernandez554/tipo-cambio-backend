package com.tipo.cambio.service;

import java.util.List;

import com.tipo.cambio.model.Tarifa;


public interface ITarifaService {

	Tarifa buscarPorCodMoneda(String codMoneda) throws Exception;
	List<Tarifa> listar() throws Exception;
	Tarifa actualizar(Tarifa tarifa) throws Exception;
	
}
