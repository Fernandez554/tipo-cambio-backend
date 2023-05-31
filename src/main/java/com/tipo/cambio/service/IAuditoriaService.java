package com.tipo.cambio.service;

import java.math.BigDecimal;

import com.tipo.cambio.model.Auditoria;
import com.tipo.cambio.model.Tarifa;

public interface IAuditoriaService extends ICRUD<Auditoria, Long>  {
	Auditoria registrar(Tarifa tarifa, String accion, BigDecimal tipoCambioAnt);
}
