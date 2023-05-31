package com.tipo.cambio.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualizarTipoCambioDTO {

	@JsonProperty("cod_moneda")
	@NotNull(message = "Especifique el codigo de moneda a actualizar")
	private String codMoneda;

	@JsonProperty("tipo_cambio")
	@NotNull(message = "Especifique el tipo de cambio")
	private BigDecimal tipoCambio;
}
