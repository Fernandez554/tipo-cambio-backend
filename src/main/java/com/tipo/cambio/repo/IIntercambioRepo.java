package com.tipo.cambio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tipo.cambio.model.Intercambio;

public interface IIntercambioRepo extends JpaRepository<Intercambio, Long> {
	
	@Query("FROM Intercambio i INNER JOIN Tarifa t ON i.id = t.id")
	List<Intercambio> listar();

}
