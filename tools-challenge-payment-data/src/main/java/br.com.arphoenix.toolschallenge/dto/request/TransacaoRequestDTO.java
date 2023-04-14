package br.com.arphoenix.toolschallenge.dto.request;

import br.com.arphoenix.toolschallenge.dto.common.FormaPagamentoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class TransacaoRequestDTO implements Serializable {
    private static final long serialVersionUID = 2983351115125578938L;

    @NotBlank(message = "Número do cartão é obrigatório")
    @Size(min = 16, max = 16, message = "Número do cartão deve conter exatamente 16 dígitos")
    private String cartao;

    @Valid
    @NotNull(message = "Descrição é obrigatória")
    private DescricaoRequestDTO descricao;

    @Valid
    @NotNull(message = "Forma de pagamento é obrigatória")
    private FormaPagamentoDTO formaPagamento;

}
