package br.com.arphoenix.toolschallenge.dto.response;

import br.com.arphoenix.toolschallenge.dto.common.IdGenericoDTO;
import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class DescricaoResponseDTO extends IdGenericoDTO implements Serializable {

    private static final long serialVersionUID = 2073075961891648456L;

    private String valor;

    private LocalDateTime dataHora;

    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    private StatusPagamento status;

}
