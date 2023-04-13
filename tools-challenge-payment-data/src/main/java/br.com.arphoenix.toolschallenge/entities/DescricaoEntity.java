package br.com.arphoenix.toolschallenge.entities;

import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DescricaoEntity extends AbstractBaseEntity{

    @Column(nullable = false)
    private String valor;

    @Column
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String estabelecimento;

    @Column(nullable = false)
    private String nsu;

    @Column(nullable = false)
    private String codigoAutorizacao;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
}
