package com.tipo.cambio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipo.cambio.dto.IntercambioResumenDTO;
import com.tipo.cambio.model.Intercambio;
import com.tipo.cambio.repo.IIntercambioRepo;
import com.tipo.cambio.service.IIntercambioService;

@Service
public class IntercambioServiceImpl implements IIntercambioService {

	@Autowired
	private IIntercambioRepo intercambioRepo;

	@Override
	public Intercambio registrar(Intercambio intercambio) throws Exception {
		return intercambioRepo.save(intercambio);
	}

	@Override
	public List<IntercambioResumenDTO> listar() throws Exception {

		List<IntercambioResumenDTO> consultas = new ArrayList<>();
		intercambioRepo.listar().forEach(x -> {
			consultas.add(new IntercambioResumenDTO(x.getTarifa().getCodMoneda(), x.getTipoCambio(),
					x.getMonto(), x.getFecReg()));
		});

		return consultas;
	}

}
