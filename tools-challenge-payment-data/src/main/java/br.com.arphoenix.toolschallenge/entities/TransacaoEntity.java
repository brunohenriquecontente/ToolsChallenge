package br.com.arphoenix.toolschallenge.entities;

import br.com.arphoenix.toolschallenge.dto.PagamentoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TransacaoEntity extends AbstractBaseEntity{

    @Column(nullable = false)
    private String cartao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DescricaoEntity descricao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FormaPagamentoEntity formaPagamento;


}
