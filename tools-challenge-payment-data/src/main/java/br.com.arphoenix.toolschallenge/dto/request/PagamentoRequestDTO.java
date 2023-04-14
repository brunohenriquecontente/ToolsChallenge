package br.com.arphoenix.toolschallenge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequestDTO implements Serializable {
    private static final long serialVersionUID = 590134374608685603L;

    private TransacaoRequestDTO transacao;

}
