package com.tipo.cambio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.repo.ITarifaRepo;
import com.tipo.cambio.service.ITarifaService;

@Service
public class TarifaServiceImpl implements ITarifaService {
	
	@Autowired
	private ITarifaRepo repo;

	@Override
	public Tarifa buscarPorCodMoneda(String codMoneda) throws Exception {
		return repo.findOneByCodMoneda(codMoneda);
	}

	@Override
	public List<Tarifa> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Tarifa actualizar(Tarifa tarifa) throws Exception {
		return repo.save(tarifa);
	}
	
}
