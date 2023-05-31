package com.tipo.cambio.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = "tarifa")
@Table(name = "auditoria")
public class Auditoria {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_tarifa", nullable = false, foreignKey = @ForeignKey(name = "FK_auditoria_tipocambio"))
	private Tarifa tarifa;

	@Column(name = "accion", nullable = true)
	private String accion;

	@Column(name = "fec_reg", nullable = true)
	private LocalDateTime fecRegistro;

	@Column(name = "tc_anterior", nullable = false)
	private BigDecimal tcAnterior;

	@Column(name = "tc_nuevo", nullable = false)
	private BigDecimal tcNuevo;

}
