package com.tipo.cambio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.repo.IGenericRepo;
import com.tipo.cambio.repo.ITarifaRepo;
import com.tipo.cambio.service.ITarifaService;

@Service
public class TarifaServiceImpl extends CRUDImpl<Tarifa, Long> implements ITarifaService {
	
	@Autowired
	private ITarifaRepo repo;

	@Override
	protected IGenericRepo<Tarifa, Long> getRepo() {
		return repo;
	}

	@Override
	public Tarifa buscarPorCodMoneda(String codMoneda) throws Exception {
		// TODO Auto-generated method stub
		return repo.findOneByCodMoneda(codMoneda);
	}

	
	

	
	
}
