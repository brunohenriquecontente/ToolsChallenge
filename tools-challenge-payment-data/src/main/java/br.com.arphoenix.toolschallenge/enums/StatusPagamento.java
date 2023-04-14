package br.com.arphoenix.toolschallenge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {

        AUTORIZADO("AUTORIZADO", 1),
        NEGADO("NEGADO", 2),
        CANCELADO("CANCELADO", 2);

        public String status;
        public Integer key;
}
