package com.tipo.cambio.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tipo.cambio.model.Tarifa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaConsultaDTO {

	@JsonProperty("monto")
	private BigDecimal monto;

	@JsonProperty("monto_tipo_cambio")
	private BigDecimal montoTipoCambio;

	@JsonProperty("moneda_origen")
	private String monedaOrigen;

	@JsonProperty("moneda_destino")
	private String monedaDestino;

	@JsonProperty("tipo_cambio")
	private BigDecimal tipoCambio;

	public RespuestaConsultaDTO(FiltroConsultaDTO filtroConsulta, Tarifa tipoCambio) {
		this.monto = filtroConsulta.getMonto();
		this.montoTipoCambio = tipoCambio.getMtoCompra().multiply(filtroConsulta.getMonto()).setScale(2,
				RoundingMode.HALF_DOWN);
		this.monedaOrigen = filtroConsulta.getMonedaOrigen();
		this.monedaDestino = filtroConsulta.getMonedaDestino();
		this.tipoCambio = tipoCambio.getMtoCompra();
	}
}
