package br.com.arphoenix.toolschallenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TransacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cartao;

    private String id;

    private DescricaoDTO descricao;

    private FormaPagamentoDTO formaPagamento;



}
