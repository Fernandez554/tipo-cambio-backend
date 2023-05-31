package com.tipo.cambio.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tipo.cambio.model.Tarifa;

public interface ITarifaRepo extends JpaRepository<Tarifa, Long> {
		
	Tarifa findOneByCodMoneda(String codMoneda);

}
