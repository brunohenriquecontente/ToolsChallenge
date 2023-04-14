package br.com.arphoenix.toolschallenge.dto.request;

import br.com.arphoenix.toolschallenge.dto.common.IdGenericoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequestDTO extends IdGenericoDTO implements Serializable {
    private static final long serialVersionUID = 590134374608685603L;

    @Valid
    private TransacaoRequestDTO transacao;

}
