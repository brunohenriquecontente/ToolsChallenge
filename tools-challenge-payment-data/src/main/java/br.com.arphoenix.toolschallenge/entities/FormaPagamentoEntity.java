package br.com.arphoenix.toolschallenge.entities;

import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import br.com.arphoenix.toolschallenge.enums.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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


