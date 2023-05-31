package com.tipo.cambio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tipo.cambio.model.Auditoria;
import com.tipo.cambio.service.IAuditoriaService;
import com.tipo.cambio.util.Constantes;

@RestController
@RequestMapping(Constantes.URL_AUDITORIA)
public class AuditoriaController {

	@Autowired
	private IAuditoriaService auditoriaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Auditoria>> listar() throws Exception {

		return new ResponseEntity<List<Auditoria>>(auditoriaService.listar(), HttpStatus.OK);

	}
}
