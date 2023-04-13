package br.com.arphoenix.toolschallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private TransacaoDTO transacao;

}
