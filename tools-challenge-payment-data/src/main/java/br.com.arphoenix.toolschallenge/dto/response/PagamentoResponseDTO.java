package br.com.arphoenix.toolschallenge.dto.response;

import br.com.arphoenix.toolschallenge.dto.common.IdGenericoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponseDTO extends IdGenericoDTO implements Serializable {
    private static final long serialVersionUID = -3830127987671260359L;

    private TransacaoResponseDTO transacao;

}
