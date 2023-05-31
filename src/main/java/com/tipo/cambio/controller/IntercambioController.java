package com.tipo.cambio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tipo.cambio.dto.IntercambioResumenDTO;
import com.tipo.cambio.service.IIntercambioService;
import com.tipo.cambio.util.Constantes;

@RestController
@RequestMapping(Constantes.URL_INTERCAMBIO)
public class IntercambioController {

	@Autowired
	private IIntercambioService intercambioService;

	@GetMapping("/listar")
	public ResponseEntity<List<IntercambioResumenDTO>> listarIntercambios() throws Exception {

		return new ResponseEntity<List<IntercambioResumenDTO>>(intercambioService.listar(), HttpStatus.OK);

	}
}
