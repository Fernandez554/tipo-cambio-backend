package com.tipo.cambio.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipo.cambio.model.Auditoria;
import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.repo.IAuditoriaRepo;
import com.tipo.cambio.repo.IGenericRepo;
import com.tipo.cambio.service.IAuditoriaService;

@Service
public class AuditoriaServiceImpl extends CRUDImpl<Auditoria, Long> implements IAuditoriaService {

	@Autowired
	private IAuditoriaRepo repo;
	
	@Override
	protected IGenericRepo<Auditoria, Long> getRepo() {
		return repo;
	}

	@Override
	public Auditoria registrar(Tarifa tarifa, String accion, BigDecimal tipoCambioAnt) {
		Auditoria auditoria = new Auditoria();
		auditoria.setTarifa(tarifa);
		auditoria.setAccion(accion);
		auditoria.setFecRegistro(LocalDateTime.now());
		auditoria.setTcNuevo(tarifa.getMtoCompra());
		auditoria.setTcAnterior(tipoCambioAnt);
		return repo.save(auditoria);
	}
	
	

}
