package br.com.arphoenix.toolschallenge.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class DescricaoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1264790729147920219L;

    private String valor;

    private LocalDateTime dataHora;

    private String estabelecimento;

}
