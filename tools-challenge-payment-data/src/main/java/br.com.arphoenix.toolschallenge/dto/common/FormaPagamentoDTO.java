package br.com.arphoenix.toolschallenge.dto.common;

import br.com.arphoenix.toolschallenge.enums.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FormaPagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1006022753672900090L;

    private TipoPagamento tipo;

    private Integer parcelas;

}
