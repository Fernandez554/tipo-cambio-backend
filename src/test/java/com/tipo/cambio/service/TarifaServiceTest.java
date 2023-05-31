package com.tipo.cambio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.repo.ITarifaRepo;
import com.tipo.cambio.service.impl.TarifaServiceImpl;

@ExtendWith(MockitoExtension.class)
class TarifaServiceTest {

	@InjectMocks
	private TarifaServiceImpl tarifaService;

	@Mock
	private ITarifaRepo tarifaRepo;

	@Mock
	Tarifa tarifa;

	ArrayList<Tarifa> listaDummyTarifa = new ArrayList<>();

	@BeforeEach
	void setUp() {
		tarifa = new Tarifa(1L, "PEN-USD", "Soles a Dolares", BigDecimal.valueOf(3.69));
		listaDummyTarifa.add(tarifa);
	}

	@Test
	public void cuandoCodMonedaNoExiste() throws Exception {
		
		when(tarifaRepo.findOneByCodMoneda(anyString())).thenReturn(null);
		Tarifa respuesta = tarifaService.buscarPorCodMoneda(anyString());
		assertNull(respuesta);
		
	}

	@Test
	public void cuandoExisteUnRegistroTarifaEnBD() throws Exception {
		
		when(tarifaRepo.findAll()).thenReturn(listaDummyTarifa);
		List<Tarifa> repuesta = tarifaService.listar();
		assertEquals(repuesta.size(), 1);

	}

	@Test
	public void cuandoSeQuiereActualizarTarifaDevuelveNulo() throws Exception {

		when(tarifaRepo.save(any())).thenReturn(null);
		Tarifa respuesta = tarifaService.actualizar(any(Tarifa.class));
		assertNull(respuesta);
		
	}

}
