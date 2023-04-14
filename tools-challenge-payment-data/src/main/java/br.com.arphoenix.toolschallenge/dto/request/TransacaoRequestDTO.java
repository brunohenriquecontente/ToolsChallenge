package br.com.arphoenix.toolschallenge.dto.request;

import br.com.arphoenix.toolschallenge.dto.common.FormaPagamentoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TransacaoRequestDTO implements Serializable {
    private static final long serialVersionUID = 2983351115125578938L;

    private String cartao;

    private DescricaoRequestDTO descricao;

    private FormaPagamentoDTO formaPagamento;



}
