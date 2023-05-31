package com.tipo.cambio.exception;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArgNotValidResponse {

	private LocalDateTime fecha;

	@JsonProperty("lst_errores")
	private Map<String, String> lstErrors;

	private String detalles;

}
