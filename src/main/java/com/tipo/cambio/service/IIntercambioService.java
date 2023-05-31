package com.tipo.cambio.service;

import java.util.List;

import com.tipo.cambio.dto.IntercambioResumenDTO;
import com.tipo.cambio.model.Intercambio;

public interface IIntercambioService {

	Intercambio registrar(Intercambio intercambio) throws Exception;
	List<IntercambioResumenDTO> listar() throws Exception;

}
