/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "fluxo_caixa")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FluxoCaixa implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String descricao;
    @Column(name = "tipo_movimento")
    private String tipoMovimento;
    private BigDecimal valor;
    @Column(name = "data_movimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimento;
}
