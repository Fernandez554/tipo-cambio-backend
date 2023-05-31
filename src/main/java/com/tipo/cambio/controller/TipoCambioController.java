package com.tipo.cambio.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tipo.cambio.dto.ActualizarTipoCambioDTO;
import com.tipo.cambio.dto.FiltroConsultaDTO;
import com.tipo.cambio.dto.RespuestaConsultaDTO;
import com.tipo.cambio.exception.ModelNotFoundException;
import com.tipo.cambio.model.Intercambio;
import com.tipo.cambio.model.Tarifa;
import com.tipo.cambio.service.IIntercambioService;
import com.tipo.cambio.service.ITarifaService;
import com.tipo.cambio.util.Constantes;

@RestController
@RequestMapping(Constantes.URL_TIPOCAMBIO)
public class TipoCambioController {

	@Autowired
	private ITarifaService tarifaService;

	@Autowired
	private IIntercambioService intercambioService;

	@PostMapping
	public ResponseEntity<RespuestaConsultaDTO> consultaTipoCambio(@Valid @RequestBody FiltroConsultaDTO consulta)
			throws Exception {

		Tarifa tipoCambio = tarifaService.buscarPorCodMoneda(consulta.getCodMoneda());
		if (tipoCambio == null) {
			throw new ModelNotFoundException(
					String.format("No existe el tipo de cambio para %s", consulta.getCodMoneda()));
		}
		intercambioService.registrar(new Intercambio(tipoCambio, consulta.getMonto(), LocalDateTime.now(), tipoCambio.getMtoCompra()));

		return new ResponseEntity<>(new RespuestaConsultaDTO(consulta, tipoCambio), HttpStatus.OK);

	}

	@PostMapping("/actualizar")
	public ResponseEntity<Tarifa> actualizarTipoCambio(@Valid @RequestBody ActualizarTipoCambioDTO dto)
			throws Exception {

		Tarifa tarifa = tarifaService.buscarPorCodMoneda(dto.getCodMoneda());
		if (tarifa == null) {
			throw new ModelNotFoundException(
					String.format("No existe el registro con codigo Moneda  %s", dto.getCodMoneda()));
		}
		tarifa.setMtoCompra(dto.getTipoCambio());

		return new ResponseEntity<>(tarifaService.actualizar(tarifa), HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Tarifa>> listarTipoCambios() throws Exception {

		return new ResponseEntity<List<Tarifa>>(tarifaService.listar(), HttpStatus.OK);

	}

}
