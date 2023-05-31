package com.tipo.cambio.repo;

import com.tipo.cambio.model.Tarifa;

public interface ITarifaRepo extends IGenericRepo<Tarifa, Long> {
		
	Tarifa findOneByCodMoneda(String codMoneda);

}
