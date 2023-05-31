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

import lombok.Data;

@Data
@Entity
@Table(name = "intercambio")
public class Intercambio {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_tarifa", nullable = false, foreignKey = @ForeignKey(name = "FK_intercambio_tarifa"))
	private Tarifa tarifa;
	
	@Column(name="monto", nullable = false, precision = 10, scale = 2)
	private BigDecimal monto;
	
	private LocalDateTime fecReg;
	
	@Column(name="tipo_cambio")
	private BigDecimal tipoCambio;
	
	public Intercambio() {}
	
	public Intercambio(Tarifa tarifa, BigDecimal monto, LocalDateTime fecReg, BigDecimal tipoCambio ) {
		this.tarifa = tarifa;
		this.monto = monto;
		this.fecReg = fecReg;
		this.tipoCambio = tipoCambio;
	}
	
}
