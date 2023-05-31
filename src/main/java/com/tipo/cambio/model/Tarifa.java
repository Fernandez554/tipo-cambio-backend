package com.tipo.cambio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tarifa", uniqueConstraints = { @UniqueConstraint(columnNames = { "cod_moneda", "descripcion" }) })
public class Tarifa {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("codigo_moneda")
	@Column(name = "cod_moneda", nullable = false)
	private String codMoneda;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	// private LocalDateTime fecTc;

	@JsonProperty("monto_compra")
	@Column(name = "mto_compra", nullable = false, precision = 10, scale = 2)
	private BigDecimal mtoCompra;

}
