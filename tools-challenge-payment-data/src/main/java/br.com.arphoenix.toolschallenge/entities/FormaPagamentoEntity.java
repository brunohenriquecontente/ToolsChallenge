package br.com.arphoenix.toolschallenge.entities;

import br.com.arphoenix.toolschallenge.enums.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class FormaPagamentoEntity  extends AbstractBaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Column(nullable = false)
    private Integer parcelas;

}


