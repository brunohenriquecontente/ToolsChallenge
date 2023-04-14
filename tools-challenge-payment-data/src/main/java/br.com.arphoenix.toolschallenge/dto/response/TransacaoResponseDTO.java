package br.com.arphoenix.toolschallenge.dto.response;

import br.com.arphoenix.toolschallenge.dto.common.FormaPagamentoDTO;
import br.com.arphoenix.toolschallenge.dto.common.IdGenericoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TransacaoResponseDTO extends IdGenericoDTO implements Serializable {
    private static final long serialVersionUID = -5222745410028122849L;

    private String cartao;

    private DescricaoResponseDTO descricao;

    private FormaPagamentoDTO formaPagamento;

}
