package com.tipo.cambio.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class IntercambioResumenDTO {
	
	@JsonProperty("cod_moneda")
	private String codMoneda;
	
	@JsonProperty("tipo_cambio")
	private BigDecimal tipoCambio;
	
	private BigDecimal monto;
	
	@JsonProperty("fecha_registro")
	private LocalDateTime fechaReg;
	
	
	public IntercambioResumenDTO(String codMoneda, BigDecimal tipoCambio, BigDecimal monto, LocalDateTime fechaReg ) {
		this.codMoneda = codMoneda;
		this.tipoCambio = tipoCambio;
		this.monto = monto;
		this.fechaReg = fechaReg;
	}
	
}
