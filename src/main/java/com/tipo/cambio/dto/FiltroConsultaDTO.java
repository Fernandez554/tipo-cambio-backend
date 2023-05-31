package com.tipo.cambio.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiltroConsultaDTO {

	@NotNull(message = "Especifique un monto")
	@Min(value = 1 , message = "monto debe ser mayor o igual a 1")
	private BigDecimal monto;
	
	@JsonProperty("moneda_origen")
	@NotNull(message = "Especifique una moneda de origen")
	@NotBlank(message = "Especifique una moneda de origen")
	private String monedaOrigen;
	
	@JsonProperty("moneda_destino")
	@NotNull(message = "Especifique una moneda de destino")
	@NotBlank(message = "Especifique una moneda de destino")
	private String monedaDestino;
	
	@JsonIgnore
	public String getCodMoneda() {
		return this.getMonedaOrigen() + "-" + this.getMonedaDestino();
	}
}
