package br.com.arphoenix.toolschallenge.dto.common;

import br.com.arphoenix.toolschallenge.enums.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@Setter
public class FormaPagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1006022753672900090L;

    @NotNull(message = "O tipo de pagamento é obrigatório")
    private TipoPagamento tipo;

    @Positive(message = "O número de parcelas deve ser maior que zero")
    private Integer parcelas;

}
