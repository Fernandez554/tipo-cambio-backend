package com.tipo.cambio.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tipo.cambio.dto.IntercambioResumenDTO;
import com.tipo.cambio.model.Intercambio;
import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.repo.IIntercambioRepo;
import com.tipo.cambio.service.impl.IntercambioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IntercambioServiceTest {

	@InjectMocks
	private IntercambioServiceImpl intercambioService;

	@Mock
	private IIntercambioRepo repo;

	@Mock
	Intercambio intercambio;

	ArrayList<Intercambio> listaDummyIntercambio = new ArrayList<>();

	@BeforeEach
	void setUp() {
		intercambio = new Intercambio(new Tarifa(), BigDecimal.valueOf(3.69), LocalDateTime.now(),BigDecimal.valueOf(0.24));
		listaDummyIntercambio.add(intercambio);
	}

	@Test
	public void cuandoSeRegistraUnNuevoIntercambio() throws Exception {
		
		when(repo.save(any())).thenReturn(intercambio);
		Intercambio respuesta = intercambioService.registrar(any());
		assertNotNull(respuesta);
		
	}
	
	@Test
	public void cuandoListarLosIntercambiosDevuelveListaVacia()  throws Exception {
		
		when(repo.listar()).thenReturn(new ArrayList<Intercambio>());
		List<IntercambioResumenDTO> resultado = intercambioService.listar();
		assertTrue(resultado.isEmpty());
		
	}
	
	@Test
	public void cuandoListarLosIntercambiosDevuelveListaLlena()  throws Exception {
		
		when(repo.listar()).thenReturn(listaDummyIntercambio);
		List<IntercambioResumenDTO> resultado = intercambioService.listar();
		assertFalse(resultado.isEmpty());
		
	}
	
}
