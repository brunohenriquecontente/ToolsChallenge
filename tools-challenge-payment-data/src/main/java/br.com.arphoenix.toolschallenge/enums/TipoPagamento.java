package br.com.arphoenix.toolschallenge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPagamento {

    AVISTA("AVISTA", 1),
    PARCELADOLOJA("PARCELADOLOJA", 2),
    PARCELADOEMISSOR("PARCELADOEMISSOR", 3);

        public String tipo;
        public Integer key;
}
