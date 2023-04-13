package br.com.arphoenix.toolschallenge.dto;

import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class DescricaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String valor;

    private LocalDateTime dataHora;

    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    private StatusPagamento status;

}
