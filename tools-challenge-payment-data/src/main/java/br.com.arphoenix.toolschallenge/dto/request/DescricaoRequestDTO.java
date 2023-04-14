package br.com.arphoenix.toolschallenge.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class DescricaoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1264790729147920219L;

    @NotBlank(message = "Valor não pode estar em branco.")
    @Size(min = 3, max = 100, message = "Valor deve conter entre 3 e 100 caracteres.")
    private String valor;

    @NotNull(message = "Data e hora não pode ser nula.")
    private LocalDateTime dataHora;

    @NotBlank(message = "Estabelecimento não pode estar em branco.")
    @Size(min = 3, max = 50, message = "Estabelecimento deve conter entre 3 e 50 caracteres.")
    private String estabelecimento;

}
